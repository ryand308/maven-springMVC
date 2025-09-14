package listener;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;

import com.mysql.cj.jdbc.AbandonedConnectionCleanupThread;

import employee.sql.EmployeeSql;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;


@WebListener
public class DataBaseListener implements ServletContextListener {
	
	
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		
		ServletContextListener.super.contextInitialized(sce);
		
		System.out.println("exsit sql table: employees");
		// create table
		this.createTable();
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce)  { 
        // 有在 Servers 寫 JNDI 都要配置driver.deregister
    	Enumeration<Driver> drivers = DriverManager.getDrivers();
    	Driver driver = null;
    	
    	while(drivers.hasMoreElements()) {
    		try {
    			driver = drivers.nextElement();
    			DriverManager.deregisterDriver(driver);
    		} catch(SQLException e) {
    			e.printStackTrace();
    		}
    	}
    	//Tomcat 不會自動關閉這個執行緒，所以需要手動關閉它，避免記憶體洩漏。
    	AbandonedConnectionCleanupThread.checkedShutdown();
    	System.out.println("mysql success final.");
    }    
	
	//-------------------------------------------------------------------
	private DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUsername("root");
		ds.setPassword("12345678");
		ds.setUrl("jdbc:mysql://localhost:3306/company");
		
		return ds;
	}
	
	private void createTable() {		
		
		try(Connection conn = this.getDataSource().getConnection();
			Statement stmt = conn.createStatement()) {			
			
			// multideclare(宣告多個 Sql Table 的建立)
			stmt.execute(EmployeeSql.CREATE_EMPLOYEE);
//			stmt.execute(TestSql);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		
	}
	
	
}
