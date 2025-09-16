package com;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("dataComponent")
@PropertySource("classpath:application.properties")
public class DataComponent {

	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.username}")
	private String user;
	@Value("${jdbc.password}")
	private String password;
	@Value("${jdbc.url.schema.empty}")
	private String blankSchemaUrl;
	@Value("${jdbc.url.schema.main}")
	private String url;
	@Value("${schema.name}")
	private String schema;
	@Value("${jdbc.initialSize}")
	private int initialSize;
	@Value("${jdbc.maxTotal}")
	private int maxTotal;
	
	public void createSchema() {
		BasicDataSource ds = (BasicDataSource)getDataSource();		
		ds.setUrl(this.blankSchemaUrl);
		
		try(Connection conn = ds.getConnection();
			Statement stmt = conn.createStatement()){
			
			String sql = "CREATE SCHEMA if not exists `"+ schema +"` DEFAULT CHARACTER SET utf8mb4";
			stmt.execute(sql);

		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public DataSource getDataSource() {
		BasicDataSource ds = new BasicDataSource();
		ds.setDriverClassName(this.driver);
		ds.setUrl(this.url);
		ds.setUsername(this.user);
		ds.setPassword(this.password);
		ds.setInitialSize(this.initialSize);
		ds.setMaxTotal(this.maxTotal);
		return ds;
	}
	


}
