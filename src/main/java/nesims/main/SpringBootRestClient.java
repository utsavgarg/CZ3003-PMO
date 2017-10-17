//This is for PMO to call CMO's API
package nesims.main;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import nesims.main.model.Report;
import org.springframework.web.client.RestTemplate;

public class SpringBootRestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/api";

	// GET
	@SuppressWarnings("unchecked")
	private static void listLatestReport() {
		int i = 1;
		System.out.println("Testing receiving Action Report API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> reportsMap = restTemplate.getForObject(REST_SERVICE_URI + "/report/",
				List.class);

		if (reportsMap != null) {
			for (LinkedHashMap<String, Object> map : reportsMap) {
				if (i++ == reportsMap.size()) {
					// end
					
					System.out.println("crisisID=" + map.get("crisisID") + "," + " name=" + map.get("name") + ","
							+ " positionInCMO=" + map.get("positionInCMO") + "," + " threatLevel=" + map.get("threatLevel") + ","
							+ " crisisType=" + map.get("crisisType") + "," + " affectedArea=" + map.get("affectedArea") + ","
							+ " estimatedCasualties=" + map.get("estimatedCasualties") + ","
							+ " crisisDuration=" + map.get("crisisDuration") + ","
							+ " crisisDetails=" + map.get("crisisDetails") + ","
							+ " courseOfAction=" + map.get("courseOfAction") + ","
							+ " consequencesOfAction=" + map.get("consequencesOfAction") + ","
							+ " cleanUpAction=" + map.get("cleanUpAction"));
				}
			}
		} else {
			System.out.println("No report exist----------");
		}
	}

	// GET
	private static void listAllReports() {
		System.out.println("Testing receiving Action Report API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> reportsMap = restTemplate.getForObject(REST_SERVICE_URI + "/report/",
				List.class);

		if (reportsMap != null) {
			for (LinkedHashMap<String, Object> map : reportsMap) {

				System.out.println("crisisID=" + map.get("crisisID") + "," + " name=" + map.get("name") + ","
						+ " positionInCMO=" + map.get("positionInCMO") + "," + " threatLevel=" + map.get("threatLevel") + ","
						+ " crisisType=" + map.get("crisisType") + "," + " affectedArea=" + map.get("affectedArea") + ","
						+ " estimatedCasualties=" + map.get("estimatedCasualties") + ","
						+ " crisisDuration=" + map.get("crisisDuration") + ","
						+ " crisisDetails=" + map.get("crisisDetails") + ","
						+ " courseOfAction=" + map.get("courseOfAction") + ","
						+ " consequencesOfAction=" + map.get("consequencesOfAction") + ","
						+ " cleanUpAction=" + map.get("cleanUpAction"));
			}
		} else {
			System.out.println("No report exist----------");
		}
	}

	// GET
	private static void getReport() {
		System.out.println("Testing getReport API----------");

		RestTemplate restTemplate = new RestTemplate();
		Report report = restTemplate.getForObject(REST_SERVICE_URI + "/report/1", Report.class);
		System.out.println(report);
	}

	// POST 
	private static void createReport() {
	System.out.println("Testing create Report API----------");

	RestTemplate restTemplate = new RestTemplate();
	Report report = new Report(10, "Test10", "General" , 4, "Type10", "Area10", 10000, "Duration10", "Detail10", "Action10", "Consequence10", "CleanUp10");
	URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/report/", report,
			Report.class);System.out.println("Location : "+uri.toASCIIString());
	}

	public static void main(String args[]) {
		createReport();
	}
}