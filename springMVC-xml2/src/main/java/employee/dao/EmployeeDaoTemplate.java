package employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dao.BasicDao;
import employee.model.Employee;
import employee.sql.EmployeeSql;

@Repository
public class EmployeeDaoTemplate implements BasicDao<Employee, Long> {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Override
	public void add(Employee m) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(EmployeeSql.GENERIC_ADD, m.getName(), m.getEmail(),m.getSalary());		
	}

	@Override
	public void update(Employee m) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(EmployeeSql.GENERIC_UPDATE, m.getName(), m.getEmail(), m.getSalary(), m.getDate(), m.getEmpId());

	}

	@Override
	public void delete(Employee m) {
		// TODO Auto-generated method stub
		jdbcTemplate.update(EmployeeSql.GENERIC_DELETE, m.getEmpId());
	}

	@Override
	public List<Employee> find() {
		// BeanRropertyRowMapper 是 RowMapper 的 子類別，自動對應java's name of field；忽略名稱的大小寫。		
		
		List<Employee> list =  jdbcTemplate.query(EmployeeSql.GENERIC_FIND, new BeanPropertyRowMapper<>(Employee.class));
		
		return list;
	}

	@Override
	public Employee findById(Long id) {
		// TODO Auto-generated method stub
		Employee emp = jdbcTemplate.queryForObject(EmployeeSql.GENERIC_FINDBYID, new BeanPropertyRowMapper<>(Employee.class), id);
		
		return emp;
	}


}
