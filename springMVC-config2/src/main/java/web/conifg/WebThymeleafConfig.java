package web.conifg;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.OptionalValidatorFactoryBean;
import org.springframework.web.context.annotation.SessionScope;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.spring6.SpringTemplateEngine;
import org.thymeleaf.spring6.templateresolver.SpringResourceTemplateResolver;
import org.thymeleaf.spring6.view.ThymeleafViewResolver;

import config.DataBaseConfig;
import employee.config.EmployeeConfig;


@EnableWebMvc
@Configuration
@ComponentScan( basePackages = {"controller.mvc3"})
@Import( {EmployeeConfig.class, DataBaseConfig.class})
public class WebThymeleafConfig implements WebMvcConfigurer{
	/**
	 *  step 1 ~ 4 是thymeleaf 在 springFramework 的基本配置
	 *  https://www.thymeleaf.org/doc/tutorials/3.1/thymeleafspring.html#spring-mvc-configuration
	 */
	 // 1. Template Resolver
    @Bean
    public SpringResourceTemplateResolver templateResolver() {
        SpringResourceTemplateResolver resolver = new SpringResourceTemplateResolver();
        resolver.setPrefix("classpath:templates/");
        resolver.setSuffix(".html");
        resolver.setTemplateMode("HTML");
        resolver.setCharacterEncoding("UTF-8");
        resolver.setCacheable(false); // 開發階段可設 false，正式環境改 true
        return resolver;
    }

    // 2. Template Engine
    @Bean
    public SpringTemplateEngine templateEngine() {
        SpringTemplateEngine engine = new SpringTemplateEngine();
        engine.setTemplateResolver(templateResolver());
        
        engine.setEnableSpringELCompiler(true);
        return engine;
    }

    // 3. View Resolver
    @Bean
    public ThymeleafViewResolver viewResolver() {
        ThymeleafViewResolver viewResolver = new ThymeleafViewResolver();
        viewResolver.setTemplateEngine(templateEngine());
        viewResolver.setCharacterEncoding("UTF-8");
        viewResolver.setContentType("text/html; charset=UTF-8");
        return viewResolver;
    }
    
    // 4. i18n(messages)
 	@Bean
     public ResourceBundleMessageSource messageSource() {
         ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
         messageSource.setBasename("messages"); // messages.properties => #{...}
         return messageSource;
 	}
 	
 	/**
     * 註冊locale解析器bean
     */
    @Bean
    public LocaleResolver localeResolver() {
        CookieLocaleResolver localeResolver = new CookieLocaleResolver();
        localeResolver.setDefaultLocale(Locale.US);
        return localeResolver;
    }
 	/**
     * 註冊locale攔截器bean
     */
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        localeChangeInterceptor.setParamName("lang"); // use request param "lang" to change locale setting; ?lang=zh_TW
        return localeChangeInterceptor;
    }

    /**
     * 註冊locale截器
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());    
        
    }
 	
	// validation
	@Override
	public Validator getValidator() {

		Validator validator = new OptionalValidatorFactoryBean();
		return validator;
	}
	
	// general use
	@Bean
	@SessionScope // 與 (default) singleton 大同小異
	public Map<Integer, String> getMap() {
		return new HashMap<>();
	}

	// Cross-Origin Resource Sharing (CORS) 跨域請求
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addCorsMappings(registry);
		
//		registry.addMapping("/**").allowedOrigins("http://localhost:8080");  // 接受的網域名稱；指定允許存取你的資源的來源（網域）
		
	}
	
	
	
}
