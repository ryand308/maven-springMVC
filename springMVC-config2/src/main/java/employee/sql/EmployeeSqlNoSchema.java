package employee.sql;

public interface EmployeeSqlNoSchema {
	
	String CREATE_EMPLOYEE = "CREATE TABLE if not exists `employees` ( "
						   + " emp_id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL COMMENT \'員工編號\',"
						   + " `name` VARCHAR(20) NOT NULL COMMENT \'姓名\',"
						   + " email VARCHAR(50) NOT NULL COMMENT \'電子郵件\',"
						   + " salary DOUBLE COMMENT \'薪資\',"
						   + " date DATETIME DEFAULT CURRENT_TIMESTAMP COMMENT \'建立日期\'"
						   + " ) COMMENT=\'員工資料表\'";
	
	// regular expression for SQL language
	String GENERIC_ADD = "INSERT INTO `employees` (`name`, `email`, `salary`) VALUES (?, ?, ?)";
	String GENERIC_UPDATE = "UPDATE `employees` SET name = ?, email = ?, salary = ?, date = ? WHERE emp_id = ?";
	String GENERIC_DELETE = "DELETE FROM `employees` WHERE emp_id = ?";
	String GENERIC_FIND = "SELECT * FROemployees";
	
	String GENERIC_FINDBYID = "SELECT * FROM `employees` WHERE emp_id = ?";
	
	// java persistence query language for parameter name
	String PARAMETER_ADD = "INSERT INTO `employees` (`name`, `email`, `salary`) VALUES (:name, :email, :salary)";
	String PARAMETER_UPDATE = "UPDATE `employees` SET name = :name, email = :email, salary = :salary, date = :date WHERE emp_id = :empId";
	String PARAMETER_DELETE = "DELETE FROM `employees` WHERE emp_id = :empId";
	
	String PARAMETER_FINDBYID = "SELECT * FROM `employees` WHERE emp_id = :empId";
	
	
}
