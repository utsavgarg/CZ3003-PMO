package nesims.main.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import nesims.main.model.ActionReport;
import nesims.main.model.ApprovalReport;
import nesims.main.model.Report;

@Controller
public class ReportController {
	
	private static final String HEADER_IMAGE = "src/main/webapp/images/header.jpg";
	private static final String SIGN_IMAGE = "src/main/webapp/images/signature.png";
	public static final String REST_SERVICE_URI = "http://localhost:8080/CMOtoPMO";
	public static final String CMO_SERVICE_URI = "http://10.27.114.25:8080/PMOtoCMO";
	
	private ByteArrayOutputStream loadPdf(String fileName) throws FileNotFoundException
	{
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
	
		byte[] buf = new byte[1024];
		try {
			for (int readNum; (readNum = fis.read(buf)) != -1;) {
				bos.write(buf, 0, readNum);
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return bos;
	}
	
    @MessageMapping("/report.generateReport")
    public void generateReport(@Payload ActionReport reportContent){
    	
    	RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> reportsMap = restTemplate.getForObject(REST_SERVICE_URI + "/report/",
				List.class);
		int i = 1;
		if (reportsMap != null) {
			String crisisID = "";
			String crisisSummary = "";
			for (LinkedHashMap<String, Object> map : reportsMap) {
				if (i++ == reportsMap.size()) {
					crisisID = String.valueOf(map.get("crisisID"));
					crisisSummary = String.valueOf(map.get("crisisDetails"));
				}
			}
		
	    	Document report = new Document(PageSize.A4, 36, 36, 150, 36);
    	
	    	try {
	    		String fileName = "reports/" + crisisID + ".pdf";
	    		PdfWriter writer = PdfWriter.getInstance(report, new FileOutputStream(new File(fileName)));
	    		report.open();
	    		
	    		PdfContentByte canvas = writer.getDirectContentUnder();
	    		Image image = Image.getInstance(HEADER_IMAGE);
	    		image.setAbsolutePosition(0, PageSize.A4.getHeight() - image.getScaledHeight());
	            canvas.addImage(image);
	            
	            Font heading = new Font(FontFamily.HELVETICA,15.0f, Font.UNDERLINE);
	            Font normal = new Font(FontFamily.HELVETICA,12.0f);
	    		
	            Paragraph h1 = new Paragraph("Crisis ID ", heading);
	            report.add(h1);
	            Paragraph p1 = new Paragraph(crisisID, normal);
	            report.add(p1);
	            report.add( Chunk.NEWLINE );
	            report.add( Chunk.NEWLINE );
	            
	            Paragraph h2 = new Paragraph("Sender", heading);
	            report.add(h2);
	            Paragraph p2 = new Paragraph(reportContent.getSender(), normal);
	            report.add(p2);
	            report.add( Chunk.NEWLINE );
	            report.add( Chunk.NEWLINE );
	            
	            Paragraph h3 = new Paragraph("Crisis Summary", heading);
	            report.add(h3);
	            Paragraph p3 = new Paragraph(crisisSummary, normal);
	            report.add(p3);
	            report.add( Chunk.NEWLINE );
	            report.add( Chunk.NEWLINE );
	            
	            Paragraph h4 = new Paragraph("Action Summary", heading);
	            report.add(h4);
	            Paragraph p4 = new Paragraph(reportContent.getContent(), normal);
	            report.add(p4);
	            report.add( Chunk.NEWLINE );
	            report.add( Chunk.NEWLINE );
	            
	            Paragraph h5 = new Paragraph("Signature", heading);
	            report.add(h5);
	            Image img = Image.getInstance(SIGN_IMAGE);
	            report.add(img);
	                       
	            report.close();
	            
	 
	        	ByteArrayOutputStream ba = loadPdf(fileName);
	        	String pdfBase64String = Base64.encodeBase64String(ba.toByteArray());
	        	
	        	
	        	ApprovalReport approvalReport = new ApprovalReport(Long.valueOf(crisisID), pdfBase64String);
	        	URI uri = restTemplate.postForLocation(CMO_SERVICE_URI + "/approvalReport/", approvalReport, ApprovalReport.class);
	        	System.out.println("Location : "+uri.toASCIIString());
	    	} catch (DocumentException | IOException e) {
             e.printStackTrace();
         }
		}else {
 			System.out.println("No report exist----------");
 		}
    }
}