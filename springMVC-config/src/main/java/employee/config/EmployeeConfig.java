package employee.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import employee.util.ConnectUitility;

@Configuration
@ComponentScan( basePackages = {"employee"})
@EnableTransactionManagement
public class EmployeeConfig {

	@Autowired
	private ConnectUitility connectUtil;
	
	@Bean
	public JdbcTemplate getSpringJdbcTemplate() {
		
		return new JdbcTemplate(connectUtil.getSpringDataSource());
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
		
		DataSource ds = connectUtil.getBasicDataSource();
		return ds;
	}
	
}
