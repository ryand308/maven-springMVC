package employee.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.javapoet.ClassName;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.stereotype.Component;

@Component
public class ConnectUitility {

	// use to connect pool  
	public BasicDataSource getBasicDataSource() {
		
		BasicDataSource basicDataSource = new BasicDataSource();
		
		basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		basicDataSource.setUrl(
				"jdbc:mysql://localhost:3306/company?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Taipei&useSSL=false");
		basicDataSource.setUsername("root");
		basicDataSource.setPassword("12345678");
		basicDataSource.setInitialSize(5);
		basicDataSource.setMaxTotal(10);

		return basicDataSource;
	}

	// connect for DriverManager
	public DriverManagerDataSource getSpringDataSource() {

		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl(
				"jdbc:mysql://localhost:3306/company?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Taipei&useSSL=false");
		ds.setUsername("root");
		ds.setPassword("12345678");
		
		return ds;
	}
	
	// connect for DriverManager
	public Connection getDriverManager() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/company?useUnicode=true&characterEncoding=UTF-8&serverTimezone=Asia/Taipei&useSSL=false";
			String user = "root";
			String password = "12345678";
			conn = DriverManager.getConnection(url, user, password);			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
	
	
}
