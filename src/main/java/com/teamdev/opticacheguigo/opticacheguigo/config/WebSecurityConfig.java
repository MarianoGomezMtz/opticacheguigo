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
	
    String[] resources = new String[]{
            "/assets/**","/css/**","/icons/**","/img/**","/js/**","/login/**"
    };
	
    
    @Override
	  protected void configure(AuthenticationManagerBuilder auth) throws Exception {

	    auth.jdbcAuthentication().dataSource(dataSource)
	    .usersByUsernameQuery("SELECT email as username, password, status as enable FROM usuarios WHERE email=?")
      .authoritiesByUsernameQuery("SELECT  email as username, rol as role FROM roles INNER JOIN roles_user ON roles.id = roles_user.id INNER JOIN usuarios ON roles_user.id = usuarios.id where email=?")
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
            .defaultSuccessUrl("/template")
            .failureUrl("/login?error=true")
            .usernameParameter("username")
            .passwordParameter("password")
            .and()
        .logout()
            .permitAll()
            .logoutSuccessUrl("/login?logout") .and().csrf().disable();
           
        
    }
    
   
 
}