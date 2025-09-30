package controller.mvc3;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import employee.model.Employee;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/gener")
public class General3Controller {
	
	// @Bean 配置在 WebThymeleafConfig
	@Autowired
	Map<Integer, String> map;

	@RequestMapping("/home")
	public String getHome() {
		
		map.clear();
		
		return "mvc3_home";
	}

	@RequestMapping("/msg/**")
	public String getMessage(Model model) {
		
		model.addAttribute("message", "<p>hello Thymeleaf, 中文</p>");
		
		return "mvc3_message";
	}
	
	@RequestMapping(value ="/params", params = {"value1", "value2"} )
	public String getParams(HttpServletRequest req, Model model) {
		
		Integer id = Integer.valueOf(req.getParameter("value1"));
		String name = req.getParameter("value2");
		
		map.put(id, name);		
		// session.setAttribute 無法作用？req.setAttribute 可以。
		model.addAttribute("map", map);
			
		return "mvc3_parameter_value";
	}
	
	@RequestMapping("/test")
	public ModelAndView getTest() {
		
		List<String> list = List.of("java", "python", "c#", "golang", "c++", "rust", "swift");		
		
		return new ModelAndView("mvc3_test", "lang", list);
	}
	
	@RequestMapping("/mvc3_trans")
	public Map<String, String> getMap() {
		//反 掃描 url 的 classpath:templates/gener/mvc3_trans.html
		
		Map<String, String> m = Map.of("util", "工具", "com", "元件", "run", "執行緒");
		
		return m;
	}
	
	@RequestMapping("/index")
	public void getJump(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// 等於 "redirect:/index.html"
		resp.sendRedirect( req.getContextPath() +"/index.html");
	}
	
	@RequestMapping("/handle")
	@ResponseBody
	public HttpEntity<Employee> handle(@RequestHeader("HOST")String host) {
		
		System.out.println(host);
		
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.set("myResponseHeader", "MyValue");	
		responseHeaders.set("content-type","application/json");	 // String 改 "text/html;charset=utf-8
		
		Employee emp = new Employee( 1L, "捷克", "j@mail", 22330, LocalDateTime.now());
			
		return new HttpEntity<Employee>( emp, responseHeaders);
	}
	
	@GetMapping("/footer")
	public String footer() {
		
		return "mvc3_footer";
	}
}
