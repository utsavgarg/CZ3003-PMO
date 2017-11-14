package nesims.main.controller;

import java.util.LinkedHashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

//Main controller for PMO subsystem which retrieves the report sent by CMO as indicated
//by the REST_SERVICE_URI from the PMO server and display the information on the client side
@Controller
public class MainController {

	//Change this IP Address to the PMO Server IP Address
	public static final String REST_SERVICE_URI = "http://10.27.199.49:8080/CMOtoPMO";

	@RequestMapping(value = { "/login" }, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("login");
		return mav;
	}

	
	@RequestMapping(value = { "/dashboard", "/" }, method = RequestMethod.GET)
	public ModelAndView dashboard(ModelMap model, HttpServletRequest request) {

		ModelAndView mav = new ModelAndView();       
				
		if (request.isUserInRole("ROLE_24-7")) {

			mav.setViewName("redirect:/contacts");
	        }
		else {
			mav.setViewName("dashboard");
	    }
	
		
		
		int i = 1;

		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> reportsMap = restTemplate.getForObject(REST_SERVICE_URI + "/proposal/",
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
		return mav;
	}

	@RequestMapping(value = { "/chat" }, method = RequestMethod.GET)
	public ModelAndView chat(ModelMap model) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("chat");

		int i = 1;

		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> reportsMap = restTemplate.getForObject(REST_SERVICE_URI + "/proposal/",
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
		return mav;
	}

	@RequestMapping(value = { "contacts" }, method = RequestMethod.GET)
	public ModelAndView contacts(ModelMap model) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("contacts");

		int i = 1;

		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> reportsMap = restTemplate.getForObject(REST_SERVICE_URI + "/proposal/",
				List.class);

		if (reportsMap != null) {
			for (LinkedHashMap<String, Object> map : reportsMap) {
				if (i++ == reportsMap.size()) {
					// end
					model.addAttribute("crisisID", map.get("crisisID"));
					model.addAttribute("threatLevel", map.get("threatLevel"));
					model.addAttribute("crisisType", map.get("crisisType"));
					model.addAttribute("crisisDetails", map.get("crisisDetails"));
				}
			}
		} else {
			System.out.println("No report exist----------");
		}
		return mav;
	}

	@RequestMapping(value = { "/generate" }, method = RequestMethod.GET)
	public ModelAndView generate(ModelMap model) {

		ModelAndView mav = new ModelAndView();
		mav.setViewName("generate");

		int i = 1;

		RestTemplate restTemplate = new RestTemplate();
		@SuppressWarnings("unchecked")
		List<LinkedHashMap<String, Object>> reportsMap = restTemplate.getForObject(REST_SERVICE_URI + "/proposal/",
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
		return mav;
	}

}
