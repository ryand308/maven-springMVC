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
	@Qualifier("employeeDaoParameterTemplate")
	private BasicDao<Employee, Long> dao;
	
	@Autowired
	@Qualifier("employeeDaoGeneric")
	private BasicExtraDao<Employee, Long> exDao;
	
	@Transactional
	public void createAndAdd(Employee emp) {
		
		exDao.createSql();
		
		dao.add(emp);
	}
	
	public Employee findEmployeeById(Long id) {		
		
		return dao.findById(id);
	}
	
	@Transactional
	public void empUpate(Employee emp) {
		
		emp.setDate(LocalDateTime.now());
		
		dao.update(emp);
	}
	
	public List<?> findAllEmployee() {
		
		return dao.find();
	}

	@Transactional
	public void removeEmployee(Long id) {
		// TODO Auto-generated method stub
		Employee emp = dao.findById(id);
		
		if(emp != null)
			dao.delete(emp);
	}
}
