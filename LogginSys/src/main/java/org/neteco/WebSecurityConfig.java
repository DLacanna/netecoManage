package org.neteco;


import org.apache.log4j.Logger;
import org.neteco.services.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	final static Logger logger = Logger.getLogger(WebSecurityConfig.class);
	
	@Autowired
	private LoginService loginService;
	
	
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		
		logger.info("SpringSecurityConfiguration_Database.configureGlobal - START");
		
		auth.userDetailsService(loginService).passwordEncoder(new BCryptPasswordEncoder());
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		
		logger.info("SpringSecurityConfiguration_database.configure - START");
		
		
		
		
		http
		.httpBasic()
		    .realmName("Neteco Gestionale")
		.and()
		
		.authorizeRequests().antMatchers("template/login.html", "/template/home.html", "/").permitAll()
		    .and().csrf()
		    .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
		    
		
	}
	

}