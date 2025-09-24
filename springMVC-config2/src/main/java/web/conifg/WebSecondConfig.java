package web.conifg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.datetime.standard.DateTimeFormatterRegistrar;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
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
	
	// validation
	@Override
	public Validator getValidator() {

		Validator validator = new OptionalValidatorFactoryBean();
		return validator;
	}
	
	// mvc 訪問 local path: resources 下的靜態資源
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
	    registry.addResourceHandler("/rs/**")
	            .addResourceLocations("/resources/css/", "/resources/js/"); // "classpath:/resources/"
	    
	}
	
	@Override
	public void addFormatters(FormatterRegistry registry) {
		DateTimeFormatterRegistrar registrar = new DateTimeFormatterRegistrar();
		registrar.setUseIsoFormat(true);
		registrar.registerFormatters(registry);
	}
	
	
}
