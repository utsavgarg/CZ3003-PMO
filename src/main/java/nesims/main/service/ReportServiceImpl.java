package nesims.main.service;

 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
 
import org.springframework.stereotype.Service;
 
import nesims.main.model.Report;
 
 
 
@Service("ReportService")
public class ReportServiceImpl implements ReportService{
     
    private static final AtomicLong counter = new AtomicLong();
     
    private static List<Report> reports;
     
    static{
        reports= populateDummyReports();
    }
 
    public List<Report> findAllReports() {
        return reports;
    }
     
    public Report findById(long id) {
        for(Report report : reports){
            if(report.getCrisisID() == id){
                return report;
            }
        }
        return null;
    }
     
    public Report findByName(String name) {
        for(Report report : reports){
            if(report.getNameOfSender().equalsIgnoreCase(name)){
                return report;
            }
        }
        return null;
    }
     
    public void saveReport(Report report) {
        report.setCrisisID(counter.incrementAndGet());
        reports.add(report);
    }
 
    public void updateReport(Report report) {
        int index = reports.indexOf(report);
        reports.set(index, report);
    }
 
    public void deleteReportById(long id) {
         
        for (Iterator<Report> iterator = reports.iterator(); iterator.hasNext(); ) {
            Report report = iterator.next();
            if (report.getCrisisID() == id) {
                iterator.remove();
            }
        }
    }
 
    public boolean isReportExist(Report report) {
        return findByName(report.getNameOfSender())!=null;
    }
     
    public void deleteAllReports(){
        reports.clear();
    }
 
    private static List<Report> populateDummyReports(){
        List<Report> reports = new ArrayList<Report>();
        reports.add(new Report(counter.incrementAndGet(),"Miss A","Secretary", "feedback1", "APPROVED"));
        reports.add(new Report(counter.incrementAndGet(),"Miss B","Secretary", "feedback2", "APPROVED"));
        reports.add(new Report(counter.incrementAndGet(),"Miss C","Secretary", "feedback3", "APPROVED"));
        reports.add(new Report(counter.incrementAndGet(),"Miss D","Secretary", "feedback4", "APPROVED"));
        return reports;
    }

	
    

 
}