package employee.valid;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import employee.model.Employee;

// 此屬於後端校正；而前端 html、javascript 也有類似的校正手段
public class EmployeeValidator implements Validator {

	// 並非最終校正；而是配置校正前，validation的元件確認。並未參與 webmvc 的 信息接收與回覆
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Employee.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		ValidationUtils.rejectIfEmpty(errors, "salary", "salary mistake");
		Employee emp = (Employee)target;
		
		//不會作用在 model 的 annotation 上；其作用類似 @Min(0) @Max(100_000)
		if(emp.getSalary() < 0)
			errors.rejectValue("salary", "negativevalue");
		else if( emp.getSalary() > 100_000)
			errors.rejectValue("salary", "can't take this salary.");
	}


}
