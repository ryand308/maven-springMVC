package employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employee.service.EmployeeService;

@RestController
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/test")
	public String getTest() {
		
		return "Hello restful";
	}
	
	@RequestMapping("/list")
	public List<?> getAllEmployee() {
		// 問題出在 json 對 date 的轉換；需要 jackson-datatype-jsr310
		return service.findAllEmployee();
	}
}
