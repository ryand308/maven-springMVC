package test.context;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(locations = "classpath:employee-beans.xml")
public class TestPool {
	@Autowired
	private ApplicationContext appctx;
	
	@Test
	public void test() throws SQLException{
	
		
		for(String name : appctx.getBeanDefinitionNames())
			System.out.println(name);
		
		DataSource ds = appctx.getBean("basicDataSource", BasicDataSource.class);
		
		System.out.println(ds);
		
		Connection conn = ds.getConnection();
		// 有代表成功連線database
		System.out.println(conn);
		conn.close();
	}
}
