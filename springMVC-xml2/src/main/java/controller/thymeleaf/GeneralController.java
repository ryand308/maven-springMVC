package controller.thymeleaf;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/gener")
public class GeneralController {

//  http://localhost:8080/maven-springMVC-xml2/app2/home
	@GetMapping("/home")
	public String getHome(Model model) {

		model.addAttribute("msg", "hello thymeleaf");
		return "home"; // -> 回傳 views 名稱 "home.html"
	}
	
	@RequestMapping("/hello")
	public String getHello(Model model) {
		
		Map<String, String> map = Map.of("v1", "peter", "v2", "poker"); 
		model.addAllAttributes(map);
		return "hello";
	}
	
}
