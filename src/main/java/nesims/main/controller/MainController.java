package nesims.main.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {
	
	@GetMapping("/login")
	public String home() {
		return "login";
	}
	
	@GetMapping("/dashboard")
	public String mainPage() {
		return "dashboard";
	}
	
	@GetMapping("/chat")
	public String chatPage() {
		return "chat";
	}

}
