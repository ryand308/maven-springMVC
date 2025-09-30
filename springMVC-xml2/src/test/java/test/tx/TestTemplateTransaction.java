package test.tx;


import java.time.LocalDateTime;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.Transactional;

import dao.BasicDao;
import employee.config.EmployeeConfig;
import employee.model.Employee;	
@SpringJUnitConfig(classes = {EmployeeConfig.class})
public class TestTemplateTransaction {
	
	// 建立 logger，建議用靜態 final
    private static final Log logger = LogFactory.getLog(TestTemplateTransaction.class);
	
	@Autowired
	@Qualifier("employeeDaoTemplate")
	private BasicDao<Employee, Long> dao;
	
	@Test
	@Transactional
	public void testUpate() {
		
		Employee emp = dao.findById(12L);
		emp.setEmail("Loye@jmail.com");
		emp.setDate(LocalDateTime.now());
		
		dao.update(emp);
		
//		int x = 10 / 0; 
		
		logger.info(emp);
		
	}

}
