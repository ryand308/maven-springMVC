package test.context;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MvcApplication {

	@Test
	public void test() {
			
		ApplicationContext appctx = new ClassPathXmlApplicationContext("mvc-context.xml");
		
		for(String name: appctx.getBeanDefinitionNames())
			System.out.println(name);
		

	}
}
