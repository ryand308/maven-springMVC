package test.context;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.context.web.WebAppConfiguration;

import employee.config.EmployeeConfig;
import mvc.MyWebConfig;

@SpringJUnitConfig(classes = {EmployeeConfig.class})
@WebAppConfiguration
@ContextConfiguration(classes = { MyWebConfig.class })
public class MvcApplication {
	
	@Autowired
    private ApplicationContext appctx;
	
	@Test
	public void test() {
		
		
		for(String name: appctx.getBeanDefinitionNames())
			System.out.println(name);
		
		
		
	}
}
