package employee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

	@RequestMapping("/add")
	public void addEmployee(@RequestBody Employee emp) {
		// 可接收 json 參數
		System.out.println(emp);

		service.add(emp);
	}
	
	@RequestMapping("/update")
	public void updateEmployee(@RequestBody Employee emp) {
		System.out.println("update: " + emp);
		
		service.update(emp);
	}
	
	@RequestMapping("/delete")
	public void deleteEmployee(@RequestBody Long id) {
		System.out.println("delete: " + id);
		
		service.remove(id);
	}
}
