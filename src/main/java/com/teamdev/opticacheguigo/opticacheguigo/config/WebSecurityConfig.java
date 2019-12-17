package com.teamdev.opticacheguigo.opticacheguigo.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	  private DataSource dataSource;

	//Necesario para evitar que la seguridad se aplique a los resources
    //Como los css, imagenes y javascripts
    String[] resources = new String[]{
            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
    };
	
    
    @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	    auth.jdbcAuthentication().dataSource(dataSource)
	    .usersByUsernameQuery("SELECT username, password, status as enable FROM user WHERE username=?")
      .authoritiesByUsernameQuery("SELECT  username, rol as role FROM rol INNER JOIN userrol ON rol.idRol = userrol.idRol INNER JOIN user ON userrol.idUser = user.idUser where username=?")
      .passwordEncoder(new BCryptPasswordEncoder());
	 
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http
        .authorizeRequests()
        .antMatchers(resources).permitAll() //permitir a todos los usuarios  
        .antMatchers("/admin/**").hasAuthority("ADMIN")
        .antMatchers("/user*").hasAnyRole("ADMIN","USER")
        .antMatchers("/","/index").permitAll()
       
         //rol de administrador o usuario
            .anyRequest().authenticated() //todas las url no incluidas requieren autentificacion
            .and()
        .formLogin()
            .loginPage("/login")
            .permitAll()
            .defaultSuccessUrl("/menu")
            .failureUrl("/login?error=true")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
        .logout()
            .permitAll()
            .logoutSuccessUrl("/login?logout") .and().csrf().disable();
           
        
    }
    
   
 
}