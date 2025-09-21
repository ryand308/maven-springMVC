package employee.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.DataComponent;

@Configuration
@ComponentScan( basePackages = {"employee"})
@Import(DataComponent.class)
@EnableTransactionManagement
public class EmployeeConfig {

	@Autowired
	private DataComponent data;
	
	@Bean
	public JdbcTemplate getSpringJdbcTemplate() {		
		return new JdbcTemplate(getDataSource());
	}
	
	@Bean
	public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
		return new NamedParameterJdbcTemplate(getDataSource());
	}
	
	@Bean
	public DataSourceTransactionManager getTransactionManager() {
		return new DataSourceTransactionManager(getDataSource());
	}
	
	@Bean
	public DataSource getDataSource() {		
		
		return data.getDataSource();
	}
	
}
