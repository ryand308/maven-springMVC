package employee.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dao.BasicDao;
import employee.model.Employee;

@Service
public class EmployeeService {
	@Autowired
	@Qualifier("employeeDaoTemplate")
  	private BasicDao<Employee, Long> dao;
	
	
	public List<?> findAllEmployee() {
		return dao.find();
	}

	@Transactional
	public void addEmployee(Employee emp) {
		
		if(emp != null)
			dao.add(emp);
	}
	
	public Employee findSingleEmployee(Long id) {
		
		return dao.findById(id);
	}
	
	@Transactional
	public void updateEmployee(Employee emp) {
		// change new time
		emp.setDate(LocalDateTime.now());
		dao.update(emp);
	}
	
	@Transactional
	public void deleteEmployee(Long id) {
		
		Employee emp = dao.findById(id);
		if(emp != null)
				dao.delete(emp);
	}
}
