package mvc2;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import config.DataBaseConfig;
import employee.config.EmployeeConfig;

@EnableWebMvc
@Configuration
@ComponentScan( basePackages = {"controller.mvc2"})
@Import( {EmployeeConfig.class, DataBaseConfig.class})
public class WebSecondConfig implements WebMvcConfigurer{

	// 實作 WebMvcConfigurer 是方法上做設定
	@Override
    public void configureViewResolvers(ViewResolverRegistry registry) {
        registry.jsp("/WEB-INF/templates/", ".jsp");
    }

	@Override
	public Validator getValidator() {

		Validator validator = new OptionalValidatorFactoryBean();
		return validator;
	}
	
	
}
