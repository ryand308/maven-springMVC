package controller.thymeleaf;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import employee.model.Employee;
import employee.service.EmployeeService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/emp")
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;	
		
	@RequestMapping("/list") 
	public String getEmpList(Model model) {
		
		List<?> list = service.findAllEmployee();		
		
		model.addAttribute("list", list);
		return "employee_list"; 
	}
	
	@RequestMapping("/form")
	public String getForm(Employee emp, HttpSession session) {
		// Model Attribute
		Stream<Employee> stream = Optional.of(emp).stream().peek(e -> System.out.println("add: " + e));
		
		if(stream.anyMatch(e -> e.getName() == null)) 
			return "employee_form";
			
		else {
			session.setAttribute("employee", emp);
//			service.addEmployee(emp);
			return "redirect:/app2/emp/info";// context path 上下文路徑
		}
	}
		
	@RequestMapping("/info")
	public String getInfo(@RequestParam(value = "empId", required = false) Long id,
										Employee emp, 
										HttpSession session, 
										Model model) {
				
		if(id == null) 
			model.addAttribute("today", LocalDateTime.now());	
		else {			
			emp = service.findSingleEmployee(id);
			session.setAttribute("employee", emp);
		}
		
		return "employee_register";
	}
	
	@RequestMapping("/update/{id}")
	public String getUpdate(@PathVariable("id") Long id, Employee emp, Model model) {
		
		Stream<Employee> stream = Optional.of(emp).stream().peek(e -> System.out.println("update: " + e));
		
		if(stream.anyMatch(e -> e.getEmpId() == null)) {
			emp = service.findSingleEmployee(id);
			model.addAttribute(emp);
			return "employee_form";
		}
		else {
			service.updateEmployee(emp);
			return "redirect:/app2/emp/list";
		}
	}
	
	@RequestMapping("/{id}/delete")
	public String getDelete(@PathVariable("id")Long id) {
		
		System.out.println("delete id:" + id);
		
//		service.deleteEmployee(id);
		return "redirect:/app2/emp/list";
	}
}
