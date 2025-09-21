package controller.mvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gener")
public class General2Controller {

	@RequestMapping("/home")
	public String getHome() {
		return "mvc2_home";
	}


}
