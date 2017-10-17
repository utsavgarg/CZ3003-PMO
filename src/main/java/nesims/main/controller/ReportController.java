package nesims.main.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import nesims.main.model.ActionReport;

@Controller
public class ReportController {
	
	private static final String HEADER_IMAGE = "resources/header.jpg";
	private static final String SIGN_IMAGE = "resources/signature.png";
	public static final String REST_SERVICE_URI = "http://localhost:8080/api";

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
	    	} catch (DocumentException | IOException e) {
             e.printStackTrace();
         }
		}else {
 			System.out.println("No report exist----------");
 		}
    }
}