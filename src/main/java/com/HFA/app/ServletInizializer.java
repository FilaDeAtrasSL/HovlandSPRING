package com.HFA.app;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInizializer extends SpringBootServletInitializer{

	

		@Override
		protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
			return application.sources(HovlandSpringApplication.class);
		}

	
	
}
