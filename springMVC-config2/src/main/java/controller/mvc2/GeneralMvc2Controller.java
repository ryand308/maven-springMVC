package controller.mvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gener")
public class GeneralMvc2Controller {

	@RequestMapping("/home")
	public String getHome() {
		return "home";
	}

}
