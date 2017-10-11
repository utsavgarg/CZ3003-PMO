//This is for CMO to call our API
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
import nesims.main.service.ReportService;
import nesims.main.config.CustomErrorType;
 
@RestController
@RequestMapping("/api")
public class RestApiController {
 
    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);
 
    @Autowired
    ReportService reportService; //Service which will do all data retrieval/manipulation work
 
    // -------------------Retrieve All Reports---------------------------------------------
 
    @RequestMapping(value = "/report/", method = RequestMethod.GET)
    public ResponseEntity<List<Report>> listAllReports() {
        List<Report> reports = reportService.findAllReports();
        if (reports.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Report>>(reports, HttpStatus.OK);
    }
 
    // -------------------Retrieve Single Report------------------------------------------
 
    @RequestMapping(value = "/report/{crisisID}", method = RequestMethod.GET)
    public ResponseEntity<?> getReport(@PathVariable("crisisID") long crisisID) {
        logger.info("Fetching Report with crisisID {}", crisisID);
        Report report = reportService.findById(crisisID);
        if (report == null) {
            logger.error("Report with crisisID {} not found.", crisisID);
            return new ResponseEntity(new CustomErrorType("Report with crisisID " + crisisID 
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Report>(report, HttpStatus.OK);
    }
 
    // -------------------Create a Report-------------------------------------------
 
    @RequestMapping(value = "/report/", method = RequestMethod.POST)
    public ResponseEntity<?> createReport(@RequestBody Report report, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Report : {}", report);
 
        if (reportService.isReportExist(report)) {
            logger.error("Unable to create. A report with name {} already exist", report.getNameOfSender());
            return new ResponseEntity(new CustomErrorType("Unable to create. A Report with name " + 
            report.getNameOfSender() + " already exist."),HttpStatus.CONFLICT);
        }
        reportService.saveReport(report);
 
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/api/report/{crisisID}").buildAndExpand(report.getCrisisID()).toUri());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
 
    // ------------------- Update a Report ------------------------------------------------
 
    @RequestMapping(value = "/report/{crisisID}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateReport(@PathVariable("crisisID") long crisisID, @RequestBody Report report) {
        logger.info("Updating Report with crisisID {}", crisisID);
 
        Report currentReport = reportService.findById(crisisID);
 
        if (currentReport == null) {
            logger.error("Unable to update. Report with crisisID {} not found.", crisisID);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Report with crisisID " + crisisID + " not found."),
                    HttpStatus.NOT_FOUND);
        }
 
        currentReport.setNameOfSender(report.getNameOfSender());
        currentReport.setPositionInPMO(report.getPositionInPMO());
        currentReport.setProposalFeedback(report.getProposalFeedback());
        currentReport.setProposalApproval(report.getProposalApproval());
        reportService.updateReport(currentReport);
        return new ResponseEntity<Report>(currentReport, HttpStatus.OK);
    }
 
    // ------------------- Delete a Report-----------------------------------------
 
    @RequestMapping(value = "/report/{crisisID}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteReport(@PathVariable("crisisID") long crisisID) {
        logger.info("Fetching & Deleting Report with crisisID {}", crisisID);
 
        Report report = reportService.findById(crisisID);
        if (report == null) {
            logger.error("Unable to delete. Report with crisisID {} not found.", crisisID);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Report with crisisID " + crisisID + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        reportService.deleteReportById(crisisID);
        return new ResponseEntity<Report>(HttpStatus.NO_CONTENT);
    }
 
    // ------------------- Delete All Reports-----------------------------
 
    @RequestMapping(value = "/report/", method = RequestMethod.DELETE)
    public ResponseEntity<Report> deleteAllReports() {
        logger.info("Deleting All Reports");
 
        reportService.deleteAllReports();
        return new ResponseEntity<Report>(HttpStatus.NO_CONTENT);
    }
 
}