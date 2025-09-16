package employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import employee.model.Employee;
import employee.service.EmployeeService;

@RestController
@RequestMapping("/rest")
public class EmployeeRestController {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/hello")
	public String hello() {
		
		return "Hello Rest";
	}
	
	@RequestMapping("/list")
	public List<?> employeeList() {
		
		return service.findAllEmployee();
	}
	
	@RequestMapping("/object/{id}")
	public Employee getEmloyee(@PathVariable("id") Long id) {
		
		return service.findEmployee(id);
	}
	
	@RequestMapping(value = "/add")
	public void addEmployee(@RequestBody Employee emp) {
		// 可接收 json 參數
		System.out.println(emp);
		
//		service.add(emp);
	}
	
	@RequestMapping(value = "/addmodel", method = RequestMethod.POST)
	public void addEmployeeModel(@ModelAttribute Employee emp) {
		// 可接收 表單 參數
		System.out.println(emp);
		
//		service.add(emp);
	}
}
