package controller.mvc3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import employee.service.EmployeeService;

@Controller
@RequestMapping("/mvc")
public class Employee3Controller {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/list")
	public String getlist(Model model) {
		
		List<?> list = service.findAllEmployee();
		
		model.addAttribute("list", list);
		
		return "mvc3_employee_list";
	}
}
