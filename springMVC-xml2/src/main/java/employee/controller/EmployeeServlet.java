package employee.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import employee.model.Employee;
import employee.sql.EmployeeSql;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/employeeServlet")
public class EmployeeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub		

		resp.setContentType("text/html; charset=utf-8");
		
		DataSource ds = (DataSource)req.getServletContext().getAttribute("DB");
		
		req.setAttribute("list", this.find(ds));
		
		req.getRequestDispatcher("/WEB-INF/views/servlet_emp.jsp").forward(req, resp);
		
	}
	
	private List<Employee> find(DataSource ds) {

		List<Employee> list = new ArrayList<>();
		
		try(Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(EmployeeSql.GENERIC_FIND)){
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setEmpId(rs.getLong("emp_id"));
				emp.setName(rs.getString("name"));
				emp.setEmail(rs.getString("email"));
				emp.setSalary(rs.getDouble("salary"));
				emp.setDate(rs.getObject("date", LocalDateTime.class));
				
				list.add(emp);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return list;
	} 

	
}
