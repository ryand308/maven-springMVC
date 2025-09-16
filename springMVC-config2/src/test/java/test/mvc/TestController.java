package test.mvc;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.test.web.servlet.MockMvc;

import employee.config.EmployeeConfig;

@SpringJUnitConfig(classes = {EmployeeConfig.class})
public class TestController {
	
	MockMvc mockMvc;
	
	@Test
	public void testHome() {
		
		
		
	}
}
