package controller.mvc2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/gener")
public class General2Controller {

	@RequestMapping("/home")
	public String getHome() {
		return "mvc2_home";
	}

	@RequestMapping("/params")
	public String getParams(@RequestParam(value = "value1", defaultValue = "0") int id,
							@RequestParam(value = "value2", defaultValue = "empty") String name,
							HttpSession session) {
		// httpSession 作用於 .jsp
		session.setAttribute("id", id);
		session.setAttribute("name", name);
		
		return "mvc2_parameter_value";
	}
}
