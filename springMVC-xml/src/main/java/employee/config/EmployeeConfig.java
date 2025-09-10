package employee.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan( basePackages = {"employee"})
@ImportResource("classpath:employee-beans.xml")
@EnableTransactionManagement
public class EmployeeConfig {
	
	@Autowired
	private DataSource dataSource;
	
	@Bean
	public JdbcTemplate getSpringJdbcTemplate() {
		
		return new JdbcTemplate(this.dataSource);
	}
	
	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(this.dataSource);
	}
	
	@Bean
	public DataSourceTransactionManager getTransactionManager() {
		return new DataSourceTransactionManager(this.dataSource);
	}
	
	

}
