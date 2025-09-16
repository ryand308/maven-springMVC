package mvc3;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;


public class WebThirdApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) {

		// web application configuration with xml.
//	    XmlWebApplicationContext context = new XmlWebApplicationContext();
//		context.setConfigLocation("classpath:mvc-context.xml");
	 
		// Load Spring web application configuration
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.register(WebThymeleafConfig.class);

		// Create and register the DispatcherServlet
		DispatcherServlet servlet = new DispatcherServlet(context);
		ServletRegistration.Dynamic registration = servletContext.addServlet("app3", servlet);
		registration.setLoadOnStartup(1);
		registration.addMapping("/app3/*");
	}
}