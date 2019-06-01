package com.test.rest.config;

import org.h2.server.web.WebServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebConfiguration {
	
	@Bean
	ServletRegistrationBean h2servletRegistration(){
		
		ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean( new WebServlet(), "/console/*");
		
		return servletRegistrationBean;
	}

}
