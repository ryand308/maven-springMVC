package controller.mvc2;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import employee.model.Employee;
import employee.service.EmployeeService;

@Controller
@RequestMapping("/mvc")
public class Employee2Controller {

	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/form")	
	public String getForm(@ModelAttribute Employee emp) {		
		
		// 避免 emp.getName() 出現 nullpointException；在未使用 validation 校正時
		Optional<Employee> optional = Optional.of(emp);
		if(optional.stream().anyMatch(e -> e.getName() == null)) {		
			
			System.out.println(emp);
			
			return "mvc2_employee_form";			
		}
		else {
			System.out.println(emp);
			service.add(emp);
			return "redirect:/form_success.html";
		}
	}
	
	@RequestMapping("/list")
	public String getList(Model model) {		
		
		model.addAttribute( "empList", service.findAllEmployee());
		
		return "mvc2_employee_list";
	}
	
	@RequestMapping("/update/{id}")
	public String getUpdate(@PathVariable("id") Long id, Employee emp, Model model) {		
		
		Optional<Employee> optional = Optional.of(emp);
		if(optional.stream().anyMatch(e -> e.getEmpId() == null)) {
			emp = service.findEmployee(id);
			model.addAttribute(emp);
			
			return "mvc2_employee_form";
		}
		else {
			
			service.update(emp);
			
			return "redirect:/app2/mvc/list";
		}

	}
	
	@RequestMapping("/delete/{id}")
	public String getDelete(@PathVariable("id") Long id) {
		
		System.out.println("delete: " + id);
		service.remove(id);
		
		return "redirect:/app2/mvc/list";
	}
}
