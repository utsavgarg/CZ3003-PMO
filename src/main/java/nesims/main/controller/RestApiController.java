//This is for CMO to call our API POST method
package nesims.main.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import nesims.main.model.Report;
import nesims.main.repository.ReportRepository;
import nesims.main.config.CustomErrorType;

@RestController
@RequestMapping("/CMOtoPMO")
public class RestApiController {

	public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

	@Autowired
	ReportRepository reportRepository; // Service which will do all data retrieval/manipulation work

	// -------------------Retrieve All
	// Reports---------------------------------------------

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/proposal/", method = RequestMethod.GET)
	public ResponseEntity<List<Report>> listAllReports() {
		List<Report> reports = reportRepository.findAllReports();
		if (reports.isEmpty()) {
			return new ResponseEntity(HttpStatus.NO_CONTENT);
			// You many decide to return HttpStatus.NOT_FOUND
		}
		return new ResponseEntity<List<Report>>(reports, HttpStatus.OK);
	}

	// -------------------Retrieve Single
	// Report------------------------------------------

	@RequestMapping(value = "/proposal/{crisisID}", method = RequestMethod.GET)
	public ResponseEntity<?> getReport(@PathVariable("crisisID") long crisisID) {
		logger.info("Fetching Report with crisisID {}", crisisID);
		Report report = reportRepository.findById(crisisID);
		if (report == null) {
			logger.error("Report with crisisID {} not found.", crisisID);
			return new ResponseEntity<Object>(new CustomErrorType("Report with crisisID " + crisisID + " not found"),
					HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Report>(report, HttpStatus.OK);
	}

	// -------------------Create a Report-------------------------------------------

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/proposal/", method = RequestMethod.POST)
	public ResponseEntity<?> createReport(@RequestBody Report report, UriComponentsBuilder ucBuilder) {
		logger.info("Creating Report : {}", report);

		if (reportRepository.isReportExist(report)) {
			logger.error("Unable to create. A report with name {} already exist", report.getCrisisID());
			return new ResponseEntity(
					new CustomErrorType(
							"Unable to create. A Report with crisisID " + report.getCrisisID() + " already exist."),
					HttpStatus.CONFLICT);
		}
		reportRepository.saveReport(report);

		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(
				ucBuilder.path("/CMOtoPMO/proposal/{crisisID}").buildAndExpand(report.getCrisisID()).toUri());
		return new ResponseEntity<String>(headers, HttpStatus.CREATED);
	}

}