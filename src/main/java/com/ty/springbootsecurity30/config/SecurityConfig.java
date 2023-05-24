package com.ty.springbootsecurity30.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * 
 * @author Mohammad-Masood-Ansari
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

	/*
	 *below method is for providing username password and role for end users 
	 *who is going to use application 
	 */
	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder){
		
		/*
		 * where passwordEncoder.encode
		 */
		UserDetails admin = User.withUsername("Basant")
				.password(passwordEncoder.encode("basant@123"))
				.roles("ADMIN")
				.build();
		
		UserDetails user = User.withUsername("Ansari")
				.password(passwordEncoder.encode("ansari@123"))
				.roles("USER")
				.build();
		/*
		 * in below line just we have to provide all the user-details object reference variable
		 * means how many user are there
		 */
		return new InMemoryUserDetailsManager(admin,user);
	}
	
	/*
	 * below code will authenticate the api url once we fire url in postman or on browser
	 * then we have to validate ...that validation we can do with login form and without login form
	 */
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		
		return httpSecurity.csrf().disable()
				.authorizeHttpRequests()
				.requestMatchers("/welcome").permitAll()
				.and()
				.authorizeHttpRequests().requestMatchers("/products/**")
				.authenticated().and().formLogin().and().build();	
	}
	
	/*
	 * below method is for to encode and decode the password..
	 * this method return type we have to passed in userDetailsService()
	 */
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}