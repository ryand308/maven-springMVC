package config;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.DataComponent;

import employee.sql.EmployeeSqlNoSchema;
import jakarta.annotation.PostConstruct;

@Configuration
@Import(DataComponent.class)
public class DataBaseConfig {
	
	@Autowired
	DataComponent data;
	
	@PostConstruct
	public void init() {		
			
		// build schema
		data.createSchema();
		// new path of url 
		DataSource ds = data.getDataSource();
		
		// create table 
		try(Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement()){
			
			stmt.execute(EmployeeSqlNoSchema.CREATE_EMPLOYEE);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
