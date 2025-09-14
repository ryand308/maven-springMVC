package rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import employee.model.Employee;
import employee.service.EmployeeService;

@RestController
public class RestGeneralController {
	@Autowired
	EmployeeService service;
	
	@RequestMapping("/hello")
	public String hello() {
		
		return "Hello Rest";
	}
	
	//Spring Framework (非 Spring Boot) 裡，無 JSON 序列化的支援
	
	@RequestMapping("/employeeList")
	public String employeeList() {
		
		List<Employee> list = (List<Employee>)service.findAllEmployee();
		String empList = "";
		for(Employee emp : list) 
			empList += emp.toString() + "<br/>";
		
		return empList;
	}
}
