package nesims.main.service;

 
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
 
import org.springframework.stereotype.Service;
 
import nesims.main.model.Report;
 
 
 
@Service("ReportService")
public class ReportService implements ReportRepository{
     
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
            if(report.getPositionInCMO().equalsIgnoreCase(name)){
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
        return findById(report.getCrisisID())!=null;
    }
     
    public void deleteAllReports(){
        reports.clear();
    }
 
    private static List<Report> populateDummyReports(){
        List<Report> reports = new ArrayList<Report>();
        reports.add(new Report(counter.incrementAndGet(), "Test1", "General" , 4, "Type1", "Area1", 10000, "Duration1", "Detail1", "Action1", "Consequence1", "CleanUp1"));
        reports.add(new Report(counter.incrementAndGet(), "Test2", "General" , 5, "Type2", "Area2", 10000, "Duration2", "Detail2", "Action2", "Consequence2", "CleanUp2"));
        reports.add(new Report(counter.incrementAndGet(), "Test3", "General" , 4, "Type3", "Area3", 10000, "Duration3", "Detail3", "Action3", "Consequence3", "CleanUp3"));
        reports.add(new Report(counter.incrementAndGet(), "Test4", "General" , 5, "Type4", "Area4", 10000, "Duration4", "Detail4", "Action4", "Consequence4", "CleanUp4"));
        return reports;
    }

	
    

 
}