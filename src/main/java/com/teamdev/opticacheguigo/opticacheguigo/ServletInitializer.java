package com.teamdev.opticacheguigo.opticacheguigo;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;



public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(OpticacheguigoApplication.class);
	}
	
	  @Override
	    public void onStartup(ServletContext container) throws ServletException {
	        WebApplicationContext context = getContext();
	        ServletRegistration.Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(context));
	        registration.setLoadOnStartup(1);
	        registration.addMapping("/*");
	        super.onStartup(container);
	    }
	  
	  private WebApplicationContext getContext() {
	        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
	        context.setConfigLocation(OpticacheguigoApplication.class.getName());
	        return context;
	    }

}
