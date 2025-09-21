package web.init;

import org.springframework.web.servlet.DispatcherServlet;

import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;

/**
 * configuration to web.xml; 利用@WebServlet的方式是可以取代 web.xml 的配置，類似於 Spring WebApplicationInitializers
 */
/* 
@WebServlet(urlPatterns = "/mvc/*", loadOnStartup = 1, name = "spring-mvc", initParams =  @WebInitParam( value = "classpath:spring-mvc-servlet.xml", name = "contextConfigLocation"))
public class MvcInitializer extends DispatcherServlet {

	private static final long serialVersionUID = 1L;

}
*/