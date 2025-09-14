package rest;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import employee.config.EmployeeConfig;

@Configuration
@ComponentScan( basePackages = {"rest"})
@Import( {EmployeeConfig.class})
public class RestConfig {

}
