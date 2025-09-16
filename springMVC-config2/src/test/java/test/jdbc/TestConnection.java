package test.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.Test;

public class TestConnection {

	@Test
	public void createSchema() {
		
		BasicDataSource ds = new BasicDataSource();
        ds.setUrl("jdbc:mysql://localhost:3306/?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
        ds.setUsername("root");
        ds.setPassword("12345678");
        
        String schema = "department";
        
        // 測試 1. 建立 schema
		try (Connection conn = ds.getConnection(); 
			 Statement stmt = conn.createStatement()) {
			
		
			stmt.execute("CREATE SCHEMA IF NOT EXISTS `" +schema +"` DEFAULT CHARACTER SET utf8mb4;");
			
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		//  改 DataSource 的 URL 指向剛建立的 schema
		ds.setUrl("jdbc:mysql://localhost:3306/"+ schema +"?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC");
		
		// 測試 2. 建立 table
		try (Connection conn = ds.getConnection(); 
				 Statement stmt = conn.createStatement()) {
				
				stmt.execute("CREATE TABLE `"+ schema +"`.`dount` ("
							+ "  `id` INT NOT NULL AUTO_INCREMENT,"
							+ "  `name` VARCHAR(45) NULL,"
							+ "  `price` INT NULL,"
							+ "  PRIMARY KEY (`id`))");
				
			} catch(SQLException e) {
				e.printStackTrace();
			}
			
	}
}
