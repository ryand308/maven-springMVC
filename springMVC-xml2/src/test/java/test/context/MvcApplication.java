package test.context;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.web.WebAppConfiguration;

@WebAppConfiguration
public class MvcApplication {

	@Test
	public void test() {
			
		ApplicationContext appctx = new ClassPathXmlApplicationContext("mvc-thymeleaf.xml");
		
		for(String name: appctx.getBeanDefinitionNames())
			System.out.println(name);
		

	}
}
