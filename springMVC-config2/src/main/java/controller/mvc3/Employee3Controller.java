package controller.mvc3;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import employee.model.Employee;
import employee.service.EmployeeService;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/mvc")
public class Employee3Controller {
	
	@Autowired
	private EmployeeService service;
	
	@RequestMapping("/list")
	public ModelAndView getlist() {
		
		List<Employee> list = (List<Employee>) service.findAllEmployee();
		
		list.sort((o1, o2) -> Long.compare( o2.getEmpId(), o1.getEmpId()));
		
		ModelAndView mav = new ModelAndView();
		mav.setViewName("mvc3_employee_list");
		mav.addObject("list", list);

		return mav;
	}
	
	@RequestMapping("/{id}/object")
	public String getObject(@PathVariable("id") Long id, HttpSession session) {		
		
		Employee emp = service.findEmployee(id);	
		System.out.println(emp);
		
		session.setAttribute("employee", emp);
		
		return "mvc3_employee_table";
	}
	
	@RequestMapping(value = "/merge", method ={RequestMethod.GET, RequestMethod.POST})
	public String getMerge(Employee emp) {
		
		Optional<Employee> optional = Optional.of(emp);
		Stream<Employee> stream = optional.stream().peek(e -> System.out.println("add: " + e));
		
		if(stream.allMatch(e -> e.getName() == null)) {
			
			return "mvc3_employee_form";
		}		
		else {
			service.add(emp);
			return "redirect:/form_success.html";
		}
	}
	
	@RequestMapping(value="/update/{id}", method ={RequestMethod.GET, RequestMethod.POST})
	public String getUpdate(@PathVariable("id") Long id, Employee emp, Model model) {	
			
		Optional<Employee> optional = Optional.of(emp);
		Stream<Employee> stream = optional.stream().peek(e -> System.out.println("update: " + e));
		
		if(stream.allMatch(e -> e.getEmpId() == null)) {
			
			emp = service.findEmployee(id);
			model.addAttribute(emp);
			
			return "mvc3_employee_form";
		}
		else {	
			service.update(emp);
			return "redirect:/app3/mvc/list";
		}
			
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	public String getDelete(@PathVariable("id") Long id) {
		
		System.out.println("delete: " + id);
		
		service.remove(id);
		return "redirect:/app3/mvc/list";
	}
	
}
