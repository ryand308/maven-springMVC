package controller.mvc3;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gener")
public class General3Controller {

	@RequestMapping("/home")
	public String getHome() {
		return "mvc3_home";
	}

	@RequestMapping("/msg")
	public String getMessage(Model model) {
		
		model.addAttribute("message", "hello Thymeleaf");
		
		return "mvc3_message";
	}
}
