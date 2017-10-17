package nesims.main.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class MainController {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/api";
	
	@GetMapping("/login")
	public String home() {
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String mainPage(ModelMap model) {
		
		int i = 1;

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> reportsMap = restTemplate.getForObject(REST_SERVICE_URI + "/report/",
				List.class);

		if (reportsMap != null) {
			for (LinkedHashMap<String, Object> map : reportsMap) {
				if (i++ == reportsMap.size()) {
					// end	
					model.addAttribute("crisisID", map.get("crisisID"));
					model.addAttribute("name", map.get("name"));
					model.addAttribute("positionInCMO", map.get("positionInCMO"));
					model.addAttribute("threatLevel", map.get("threatLevel"));
					model.addAttribute("crisisType", map.get("crisisType"));
					model.addAttribute("affectedArea", map.get("affectedArea"));
					model.addAttribute("estimatedCasualties", map.get("estimatedCasualties"));
					model.addAttribute("crisisDuration", map.get("crisisDuration"));
					model.addAttribute("crisisDetails", map.get("crisisDetails"));
					model.addAttribute("courseOfAction", map.get("courseOfAction"));
					model.addAttribute("consequencesOfAction", map.get("consequencesOfAction"));
					model.addAttribute("cleanUpAction", map.get("cleanUpAction"));
				}
			}
		} else {
			System.out.println("No report exist----------");
		}
		return "dashboard";
	}
	
	@GetMapping("/chat")
	public String chatPage(ModelMap model) {
		int i = 1;

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> reportsMap = restTemplate.getForObject(REST_SERVICE_URI + "/report/",
				List.class);

		if (reportsMap != null) {
			for (LinkedHashMap<String, Object> map : reportsMap) {
				if (i++ == reportsMap.size()) {
					// end	
					model.addAttribute("crisisID", map.get("crisisID"));
					model.addAttribute("name", map.get("name"));
					model.addAttribute("positionInCMO", map.get("positionInCMO"));
					model.addAttribute("threatLevel", map.get("threatLevel"));
					model.addAttribute("crisisType", map.get("crisisType"));
					model.addAttribute("affectedArea", map.get("affectedArea"));
					model.addAttribute("estimatedCasualties", map.get("estimatedCasualties"));
					model.addAttribute("crisisDuration", map.get("crisisDuration"));
					model.addAttribute("crisisDetails", map.get("crisisDetails"));
					model.addAttribute("courseOfAction", map.get("courseOfAction"));
					model.addAttribute("consequencesOfAction", map.get("consequencesOfAction"));
					model.addAttribute("cleanUpAction", map.get("cleanUpAction"));
				}
			}
		} else {
			System.out.println("No report exist----------");
		}
		return "chat";
	}
	
	@GetMapping("/contacts")
	public String contactPage() {
		
		return "contacts";
	}
	
	
	@GetMapping("/generate")
	public String generatePage(ModelMap model) {
		
		int i = 1;

		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> reportsMap = restTemplate.getForObject(REST_SERVICE_URI + "/report/",
				List.class);

		if (reportsMap != null) {
			for (LinkedHashMap<String, Object> map : reportsMap) {
				if (i++ == reportsMap.size()) {
					// end	
					model.addAttribute("crisisID", map.get("crisisID"));
					model.addAttribute("name", map.get("name"));
					model.addAttribute("positionInCMO", map.get("positionInCMO"));
					model.addAttribute("threatLevel", map.get("threatLevel"));
					model.addAttribute("crisisType", map.get("crisisType"));
					model.addAttribute("affectedArea", map.get("affectedArea"));
					model.addAttribute("estimatedCasualties", map.get("estimatedCasualties"));
					model.addAttribute("crisisDuration", map.get("crisisDuration"));
					model.addAttribute("crisisDetails", map.get("crisisDetails"));
					model.addAttribute("courseOfAction", map.get("courseOfAction"));
					model.addAttribute("consequencesOfAction", map.get("consequencesOfAction"));
					model.addAttribute("cleanUpAction", map.get("cleanUpAction"));
				}
			}
		} else {
			System.out.println("No report exist----------");
		}
		return "generate";
	}

}
