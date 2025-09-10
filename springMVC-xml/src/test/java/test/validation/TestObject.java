package test.validation;

import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;

import employee.model.Employee;
import employee.valid.EmployeeValidator;

public class TestObject {

	
	public static void main(String[] args) {

		Employee emp = new Employee();
		
		emp.setEmpId(10L);
		emp.setSalary(-1);
		
		DataBinder binder = new DataBinder(emp);
		
		binder.setValidator(new EmployeeValidator());
		
		// ✅ 呼叫 validate() 才會觸發驗證
	    binder.validate();
		
		BindingResult result = binder.getBindingResult();
	  
		System.out.println(result.getAllErrors());
	}
}
