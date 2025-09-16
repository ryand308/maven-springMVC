package controller.mvc2;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employee.service.EmployeeService;

@RestController
@RequestMapping("/rest")
public class EmployeeRest2Controller {
	
	@Autowired
	EmployeeService service;
	
	@RequestMapping("/hello")
	public String hello() {
		
		return "Hello Rest";
	}
	
	@RequestMapping(value="/employeeList")
	public List<?> employeeList() {
		
		return service.findAllEmployee();
	}
}
