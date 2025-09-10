package employee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import employee.model.Employee;
import employee.service.EmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {
		
	@Autowired
	private EmployeeService service;

	/* 使用 @validated model，後面緊跟的參數要是 BindingResult 才不會抱錯 
	 */
	@RequestMapping("/form")
	public String getForm(@Validated Employee emp, BindingResult result, Model m,Errors error) {

		// BindingResult 建立參數是 表單再回傳會接收到 result 參數內判斷是否符合"校正條件"；@Aalidated 使用時有必要存在
		if(error.hasErrors()) {
			m.addAttribute(emp);
			return "employee_form";				
		}
		// 新增
		service.createAndAdd(emp);
		return "redirect:/form_success.html";
		
	}

	@RequestMapping("/update/{id}")
	public String getupdate(@Validated Employee emp, BindingResult result, @PathVariable("id") Long id, Model m, Errors error) {
		
		if(error.hasErrors()) {
			emp = service.findEmployeeById(id);
			m.addAttribute(emp);
			return "employee_form";
		}
		// 修改
		service.empUpate(emp);
		return "redirect:/form_success.html";
	}
	
	@RequestMapping("/list")
	public String getList(Model m) {
		
		m.addAttribute( "empList", service.findAllEmployee());
		return "employee_list";
	}
	
	@RequestMapping("/remove/{id}")
	public String getRemove(@PathVariable("id") Long id) {
		// 刪除
		service.removeEmployee(id);
		
		return "redirect:/form_success.html";
	}
}
