package test.context;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import employee.config.EmployeeConfig;
import mvc2.WebSecondConfig;

@SpringJUnitConfig(classes = {EmployeeConfig.class})
public class TestApplication {

	@Test
	public void test() {
			
		ApplicationContext appctx = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		
		for(String name: appctx.getBeanDefinitionNames())
			System.out.println(name);
		
		
		
	}
}
