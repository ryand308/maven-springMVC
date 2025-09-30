package filter;

import org.springframework.web.filter.CharacterEncodingFilter;

import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.annotation.WebInitParam;

@WebFilter(value="/*" , initParams = { @WebInitParam( name = "encoding", value = "UTF-8"),
						   @WebInitParam( name = "forceResponseEncoding", value = "true")})
public class SpringEncodeFilter extends CharacterEncodingFilter{

	// encoding change utf-8； 已經不需要額外布署，大多都為 utf-8 編碼
}
