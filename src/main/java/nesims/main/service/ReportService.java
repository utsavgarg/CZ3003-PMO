package nesims.main.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.stereotype.Service;

import nesims.main.model.Report;
import nesims.main.repository.ReportRepository;

//Database Class which contains methods to interact with the database and API controller
@Service("ReportService")
public class ReportService implements ReportRepository {

	private static List<Report> reports;

	static {
		reports = populateDummyReports();
	}

	public List<Report> findAllReports() {
		return reports;
	}

	public Report findById(long id) {
		for (Report report : reports) {
			if (report.getCrisisID() == id) {
				return report;
			}
		}
		return null;
	}

	public Report findByName(String name) {
		for (Report report : reports) {
			if (report.getPositionInCMO().equalsIgnoreCase(name)) {
				return report;
			}
		}
		return null;
	}

	public void saveReport(Report report) {
		reports.add(report);
	}

	public void updateReport(Report report) {
		int index = reports.indexOf(report);
		reports.set(index, report);
	}

	public void deleteReportById(long id) {

		for (Iterator<Report> iterator = reports.iterator(); iterator.hasNext();) {
			Report report = iterator.next();
			if (report.getCrisisID() == id) {
				iterator.remove();
			}
		}
	}

	public boolean isReportExist(Report report) {
		return findById(report.getCrisisID()) != null;
	}

	public void deleteAllReports() {
		reports.clear();
	}

	private static List<Report> populateDummyReports() {
		List<Report> reports = new ArrayList<Report>();
		reports.add(new Report(1, "Test1", "General", 4, "Type1", "Area1", 10000, "Duration1", "Detail1", "Action1",
				"Consequence1", "CleanUp1"));
		reports.add(new Report(2, "Test2", "General", 5, "Type2", "Area2", 10000, "Duration2", "Detail2", "Action2",
				"Consequence2", "CleanUp2"));
		reports.add(new Report(3, "Test3", "General", 4, "Type3", "Area3", 10000, "Duration3", "Detail3", "Action3",
				"Consequence3", "CleanUp3"));
		reports.add(new Report(4, "Kevin", "General", 5, "Rougue A.I", "Area4", 10000, "1 HR",
				"It follows warnings that scientists have successfully trained computers to use artificial intelligence to learn from experience – and one day they could be smarter than their creators.\r\n"
						+ "\r\n"
						+ "You might be familiar with chatbots in Facebook Messenger or as virtual sales assistants found on a number of online shops.\r\n"
						+ "\r\n"
						+ "They've been relatively unsophisticated until now - repeating back a set script dependant on what you type into their chatboxes.",
				"To do this effectively, the super-smart software realised it would be more effective to write and use their own language - which is completely incomprehensible to humans.\r\n"
						+ "\r\n"
						+ "In a blogpost, the Facebook researchers wrote: \"To date, existing work on chatbots has led to systems that can hold short conversations and perform simple tasks such as booking a restaurant.",
				"One of the world's smartest men, Professor Stephen Hawking has also warned that super-smart software will spell the end of our species.",
				"He's claimed that we must leave planet Earth within 100 years - or face extinction as machines rise up and overtake us in the evolutionary race."));
		return reports;
	}

}