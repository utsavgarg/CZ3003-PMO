package nesims.main.repository;

import java.util.List;

import nesims.main.model.Report;

//Interface class which contains all the database calling methods
public interface ReportRepository {

	Report findById(long id);

	Report findByName(String name);

	void saveReport(Report report);

	void updateReport(Report report);

	void deleteReportById(long id);

	List<Report> findAllReports();

	void deleteAllReports();

	boolean isReportExist(Report report);

}