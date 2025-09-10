package controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	//  http://localhost:8080/maven-springMVC-xml/mvc/home
	@GetMapping("/home")
	public String getHome() {
		return "home"; // -> 回傳 views 名稱 "home.jsp"
	}
	
	
}
