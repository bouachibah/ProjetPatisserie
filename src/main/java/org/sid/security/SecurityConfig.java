package org.sid.security;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 @Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 
	auth.inMemoryAuthentication()
	 
     .withUser("admin").roles("ADMIN").password("{noop}123456")
     .roles("USER","ADMIN");
	
	auth.inMemoryAuthentication()
     .withUser("user").password("{noop}123456")
     .roles("USER")
     ;
}

@Override
	protected void configure(HttpSecurity http) throws Exception {
	http.formLogin();
	http.authorizeRequests().antMatchers("/index").hasRole("USER");
	http.authorizeRequests().antMatchers("/form","/save","/confirm").hasRole("ADMIN");
	}
}
