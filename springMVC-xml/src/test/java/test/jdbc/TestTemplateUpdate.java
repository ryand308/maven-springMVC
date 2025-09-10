package test.jdbc;

import java.time.LocalDateTime;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import dao.BasicDao;
import employee.config.EmployeeConfig;
import employee.model.Employee;

@SpringJUnitConfig(classes = {EmployeeConfig.class})
public class TestTemplateUpdate {

	@Autowired
	@Qualifier("employeeDaoTemplate")
	private BasicDao<Employee, Long> dao;
	
	@Test
	public void testFindAll() {
		
		var list = dao.find();
		
		for(Employee emp: list)
			System.out.println(emp);
	}
	
//	@Test
	public void testFindSingle() {
		
		Employee emp = dao.findById(3L);
		
		System.out.println(emp);
	}
	
//	@Test
	public void testAdd() {
		
		Employee emp = new Employee();
		emp.setName("Taylor");
		emp.setEmail("t@gmail.com");
		emp.setSalary(122_000);
		
		dao.add(emp);	
		
	}
	
//	@Test
	public void testUpate() {
		
		Employee emp = dao.findById(4L);
		emp.setEmail("Jundy@jmail.com");
		emp.setDate(LocalDateTime.now());
		
		dao.update(emp);
	}
	
//	@Test
	public void testDelete() {
		
		Employee emp = dao.findById(6L);
		
		if(emp != null)
			dao.delete(emp);
	}	
}
