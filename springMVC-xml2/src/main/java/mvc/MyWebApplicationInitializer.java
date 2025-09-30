package mvc;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletRegistration;

public class MyWebApplicationInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) {
		
		XmlWebApplicationContext appContext = new XmlWebApplicationContext();
		appContext.setConfigLocation("classpath:mvc-context.xml");

		ServletRegistration.Dynamic registration = container.addServlet("app", new DispatcherServlet(appContext));
		registration.setLoadOnStartup(1);
		registration.addMapping("/app/*");
	}
}
