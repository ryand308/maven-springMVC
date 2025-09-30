package employee.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dao.BasicDao;
import dao.BasicExtraDao;
import employee.model.Employee;
import employee.sql.EmployeeSql;



@Repository
public class EmployeeDaoGeneric implements BasicDao<Employee, Long>, BasicExtraDao<Employee, Long>{
	
	@Autowired
	private DataSource ds;
	
	@Override
	public void createSql() {
		
		try(Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement()) {
			
			stmt.execute(EmployeeSql.CREATE_EMPLOYEE);
			
		}catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	@Override
	public void add(Employee m) {
		// TODO Auto-generated method stub
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(EmployeeSql.GENERIC_ADD)) {
			
			pstmt.setString(1, m.getName());
			pstmt.setString(2, m.getEmail());
			pstmt.setDouble(3, m.getSalary());
			
			pstmt.execute();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(Employee m) {
		try(Connection conn = ds.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(EmployeeSql.GENERIC_UPDATE)) {
				
				pstmt.setString(1, m.getName());
				pstmt.setString(2, m.getEmail());
				pstmt.setDouble(3, m.getSalary());
				pstmt.setObject(4, m.getDate());
				pstmt.setLong(5, m.getEmpId());
				
				pstmt.execute();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		
	}

	@Override
	public void delete(Employee m) {
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(EmployeeSql.GENERIC_DELETE)){
			
			pstmt.setLong(1, m.getEmpId());
			
			pstmt.execute();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Employee> find() {

		List<Employee> list = new ArrayList<>();
		
		try(Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(EmployeeSql.GENERIC_FIND)){
			
			while(rs.next()) {
				Employee emp = findById(rs.getLong("emp_id"));
				list.add(emp);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	}

	@Override
	public Employee findById(Long id) {
		
		try(Connection conn = ds.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(EmployeeSql.GENERIC_FINDBYID);) {
			
			pstmt.setLong(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(id);
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setDate(rs.getObject("date", LocalDateTime.class));
				
				rs.close();
				return emp;
			}			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<Employee> findByName(String name) {
		// TODO Auto-generated method stub
		
		return null;
	}

}
