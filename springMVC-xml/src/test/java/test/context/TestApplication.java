package test.context;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import employee.config.EmployeeConfig;

public class TestApplication {
	
	@Test
	public void test() {	
		
		ApplicationContext appctx = new AnnotationConfigApplicationContext(EmployeeConfig.class);
		
		for(String name: appctx.getBeanDefinitionNames())
			System.out.println(name);
		
		
		System.out.println("junit jupiter 5");
		
		
	}
}
