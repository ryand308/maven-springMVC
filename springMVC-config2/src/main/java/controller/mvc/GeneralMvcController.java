package controller.mvc;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/gener")
public class GeneralMvcController {

	@RequestMapping("/home")
	public String getHome() {
		return "home";
	}
	
	@RequestMapping(value = "/paraValue")
	public String getParaValue(@RequestParam("value1") int v1, @RequestParam("value2") String v2, Model model) {
		
		Map<String, Object> map = Map.of("id", v1, "name", v2);
		model.addAllAttributes(map);
		
		return "parameter_value";
	}
}
