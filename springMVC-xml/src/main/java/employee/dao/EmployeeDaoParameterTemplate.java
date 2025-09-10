package employee.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import dao.BasicDao;
import employee.model.Employee;
import employee.sql.EmployeeSql;
	
@Repository
public class EmployeeDaoParameterTemplate implements BasicDao<Employee , Long>{
	
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;
	
	@Override
	public void add(Employee m) {
		// TODO Auto-generated method stub
		namedParameterJdbcTemplate.update(EmployeeSql.QUERY_ADD, new BeanPropertySqlParameterSource(m));
		
	}

	@Override
	public void update(Employee m) {
		// TODO Auto-generated method stub
		namedParameterJdbcTemplate.update(EmployeeSql.QUERY_UPDATE, new BeanPropertySqlParameterSource(m));
	}

	@Override
	public void delete(Employee m) {
		// TODO Auto-generated method stub
		namedParameterJdbcTemplate.update(EmployeeSql.QUERY_DELETE, new BeanPropertySqlParameterSource(m));
	}

	@Override
	public List<Employee> find() {
		// TODO Auto-generated method stub		
		List<Employee> list = namedParameterJdbcTemplate.query(EmployeeSql.GENERIC_FIND, new BeanPropertyRowMapper<>(Employee.class));
		
		return list;
	}

	@Override
	public Employee findById(Long id) {
		
		MapSqlParameterSource params = new MapSqlParameterSource();
		params.addValue("empId", id);
		
		Employee emp = namedParameterJdbcTemplate.queryForObject(EmployeeSql.QUERY_FINDBYID, params, new BeanPropertyRowMapper<>(Employee.class));

		return emp;
	}

	
}
