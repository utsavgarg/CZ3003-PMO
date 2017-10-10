package bootsample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String home() {
		return "index";
	}
	
	@PostMapping("/dashboard")
	public String mainPage() {
		return "dashboard";
	}

}