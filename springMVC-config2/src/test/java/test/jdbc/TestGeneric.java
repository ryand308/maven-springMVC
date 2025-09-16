package test.jdbc;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;

import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import dao.BasicDao;
import dao.BasicExtraDao;
import employee.config.EmployeeConfig;
import employee.model.Employee;

@SpringJUnitConfig(classes = {EmployeeConfig.class})
public class TestGeneric {
	
	@Autowired
	@Qualifier("employeeDaoGeneric")
	BasicDao<Employee, Long> dao;
	
	@Autowired
	@Qualifier("employeeDaoGeneric")
	BasicExtraDao<Employee, Long> exDao;
	
//	@Test
	public void testAdd() {
			
		Employee emp = new Employee();
		emp.setName("Lily");
		emp.setEmail("Lily@lmail.com");
		emp.setSalary(7_000);
		
		dao.add(emp);
		
		System.out.println("mysql is successful connection~");
	}
	
//	@Test
	public void testFindSingle() {
		
		Employee emp = dao.findById(1L);	
		
		System.out.println(emp);
		
	}
	
//	@Test
	public void testUpdate() {
		
		Employee emp = dao.findById(4L);
		
		if(emp != null) {
			emp.setName("Judy");
			emp.setSalary(8000);
			emp.setDate(LocalDateTime.now());
			
			dao.update(emp);			
		}
		
		System.out.println(emp);
	}
	
//	@Test
	public void testDelete() {
		
		Employee emp = dao.findById(2L);
		
		if(emp != null)
			dao.delete(emp);
	}
	
//	@Test
	public void testFindAll() {
		
		var list = dao.find();
		
		for(Employee emp: list)
			System.out.println(emp);
		
	}
	
	@Autowired
	private DataSource ds;
	
//	@Test
	public void testCreate() {
		
		String sql = "CREATE TABLE if not exists `company`.`test` ( `id` INT NOT NULL AUTO_INCREMENT,"
				+ "  `first` VARCHAR(45) NULL,  PRIMARY KEY (`id`))";
		
		try( Connection conn = ds.getConnection();
			 Statement stmt = conn.createStatement();) {
			
			stmt.execute(sql);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		
	}
	
//	@Test
	public void testTop() {
		
		String sql = "SELECT * FROM `company`.`test` LIMIT 1";
		
		try( Connection conn = ds.getConnection();
			 Statement stmt = conn.createStatement();) {
			
			stmt.execute(sql);
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}		
		
	}
}
