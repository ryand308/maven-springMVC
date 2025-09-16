package test.context;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.DataComponent;

import config.DataBaseConfig;

@SpringJUnitConfig(classes = DataBaseConfig.class)
public class TestContext {

	@Autowired
	ApplicationContext appctx;
	
	@Test
	public void test() {
		
		for(String name: appctx.getBeanDefinitionNames())
			System.out.println(name);
		
		DataComponent com = appctx.getBean(DataComponent.class);
		
//		System.out.println(com.getSchemaUrl());
//		System.out.println(com.getUrl());
//		System.out.println(com.getScheme());
	}
}
