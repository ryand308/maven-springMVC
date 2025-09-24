package controller.mvc;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import employee.model.Employee;
import employee.service.EmployeeService;

@Controller
@RequestMapping("/mvc")
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	
	@RequestMapping("/list")
	public String getList(Model model) {
		
		System.out.println("call list");
		model.addAttribute( "empList", service.findAllEmployee());
		
		return "employee_list";
	}
	
	@RequestMapping("/update/{id}")
	public String getEmployee(@PathVariable("id") Long id, Model model) {
		
		model.addAttribute("emp", service.findEmployee(id));
		
		return "employee_update";		
	}
	
	@RequestMapping("/save")
	public String getSave(Employee emp) {
		
		System.out.println(emp);
		
		Optional<Employee> optional = Optional.of(emp);
		if(optional.stream().allMatch(e -> e.getName() == null)) {
			
			return "employee_form";
		}
		else {
			service.add(emp);
			
			return "redirect:/form_success.html";
		}
		
	}
	
	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String getUpdate(Employee emp) {
		
		// spring 會自動對應 html 的 from 物件的變數名稱；方便搭配 dao。		
		service.update(emp);
		
		return "redirect:/app/mvc/list";
	}

	@RequestMapping("/remove")
	public String getRemove(@RequestParam("empid") Long empid)  {
		
		System.out.println(empid);		
		service.remove(empid);		

		return "redirect:/app/mvc/list";
	}
	

}

