package nesims.main.controller;

import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/CMOtoPMO";
	
	

	
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public ModelAndView login() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("login");
	    return mav;
        }
	
	@RequestMapping(value={"/dashboard", "/"}, method = RequestMethod.GET)
	public ModelAndView dashboard(ModelMap model) {
		
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("dashboard");
	    
	    int i = 1;

		RestTemplate restTemplate = new RestTemplate();
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
	
	@RequestMapping(value={"/chat"}, method = RequestMethod.GET)
	public ModelAndView chat(ModelMap model) {
		
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("chat");
	    
	    int i = 1;

		RestTemplate restTemplate = new RestTemplate();
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
	
	
	@RequestMapping(value={"contacts"}, method = RequestMethod.GET)
	public ModelAndView contacts() {
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("contacts");
	    return mav;
        }

	
	@RequestMapping(value={"/generate"}, method = RequestMethod.GET)
	public ModelAndView generate(ModelMap model) {
		
	    ModelAndView mav = new ModelAndView();
	    mav.setViewName("generate");
	    
	    int i = 1;

		RestTemplate restTemplate = new RestTemplate();
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
