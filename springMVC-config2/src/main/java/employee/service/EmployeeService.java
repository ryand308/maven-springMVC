package employee.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BasicDao;
import dao.BasicExtraDao;
import employee.model.Employee;

@Service
public class EmployeeService {

	@Autowired
	@Qualifier("employeeDaoTemplate")
	private BasicDao<Employee, Long> dao;
	
	@Autowired
	@Qualifier("employeeDaoTemplate")
	private BasicExtraDao<Employee, Long> exDao;
	
	//----------------------------------------------------
	
	public List<?> findAllEmployee() {
		
		return dao.find();
	}
	
	public Employee findEmployee(Long id) {
		
		return dao.findById(id);
		
	}
	
	@Transactional
	public void add(Employee emp) {
		
		dao.add(emp);
	}
	
	@Transactional
	public void update(Employee emp) {
		emp.setDate(LocalDateTime.now());
		System.out.println(emp);
		
		dao.update(emp);
	}
	
	public void remove(Long id) {
		
		
		Employee emp = dao.findById(id);
		if(emp != null)
			dao.delete(emp);
	}
}
