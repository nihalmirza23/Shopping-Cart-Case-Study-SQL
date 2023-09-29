package com.profile.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.profile.app.jwtfilter.JwtFilter;
import com.profile.app.service.MyUserDetailsService;

@Configuration
public class SecurityConfig  {
	
	
	 
	 @Autowired
	 private MyUserDetailsService myUserDetailsService;
	 
	 
	 
	 
	 @Autowired
	 private JwtFilter jwtRequestFilter;
	 
	 
	 
	 	@Bean
		protected AuthenticationManager authenticationManager
		        (AuthenticationConfiguration authConfig) throws Exception {
			
			return authConfig.getAuthenticationManager();	
			
	 	}
	 	
			@Bean
			public AuthenticationProvider getAuthProvider() {
				DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
				auth.setUserDetailsService(myUserDetailsService);
				auth.setPasswordEncoder(getEncryptPassword());
				
				return auth;
			}
			
			
			
			@Bean
			public PasswordEncoder getEncryptPassword() {
				PasswordEncoder encoder = new BCryptPasswordEncoder();
				return encoder;
			}
			
			
			@Bean
			public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
				
				http.authenticationProvider(getAuthProvider());
				http.csrf().disable().authorizeRequests()
						.antMatchers(HttpMethod.GET,"/api/user/username/**").permitAll() 
						.antMatchers(HttpMethod.GET,"/user/user/login").authenticated()
						.antMatchers(HttpMethod.POST,"/api/user").permitAll()
						.antMatchers(HttpMethod.GET,"/api/user").authenticated()     // Aus
						.antMatchers(HttpMethod.GET,"/api/user/*").authenticated()  //aut
						.antMatchers(HttpMethod.PUT,"/api/update/user**").authenticated() //aut
						.antMatchers(HttpMethod.DELETE,"/api/user/**").authenticated()    //aut
						.antMatchers(HttpMethod.GET,"/api/user/mobileno/**").authenticated() //aut
						.antMatchers(HttpMethod.GET,"/api/user/email/**").authenticated() //aut   
						
						.antMatchers(HttpMethod.GET,"/api/user").authenticated() 
									
						
						.anyRequest().permitAll()
						.and()
						.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				
				http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
			
				return http.build();
				
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	 
//	 
//	 @Bean
//	    public BCryptPasswordEncoder passwordEncoder() {
//	        return new BCryptPasswordEncoder();
//	    }
//	 
//	 @Bean
//	
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//			http.authorizeRequests()
//		 .antMatchers(HttpMethod.POST,"/api/user").permitAll()
//			.antMatchers(HttpMethod.GET,"/api/user").permitAll() // Aus
//			.antMatchers(HttpMethod.GET,"/api/user/**").permitAll() //aut
//			.antMatchers(HttpMethod.PUT,"/api/update/user**").permitAll() //aut
//			.antMatchers(HttpMethod.DELETE,"/api/user/**").permitAll() //aut
//			.antMatchers(HttpMethod.GET,"/api/user/mobileno/**").permitAll() //aut
//			.antMatchers(HttpMethod.GET,"/api/user/email/**").permitAll() //aut   
//			.antMatchers(HttpMethod.GET,"/api/user/username/**").permitAll() 
//
//			.anyRequest().permitAll()
//			.and()
//			.httpBasic()
//			.and().csrf().disable()
//			.cors().disable();
//			http.authenticationProvider(authenticationProvider());
//		 	return http.build();
//	    }
//	     
//	    @Bean
//	    public WebSecurityCustomizer webSecurityCustomizer() {
//	    	return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
//	         
//	    }
//	    @Bean
//	    public AuthenticationManager authenticationManager(
//	            AuthenticationConfiguration authConfig) throws Exception {
//	        return authConfig.getAuthenticationManager();
//	    }
//	    @Bean
//	    public DaoAuthenticationProvider authenticationProvider() {
//	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//	         
//	        authProvider.setUserDetailsService(userDetailsService());
//	        authProvider.setPasswordEncoder(passwordEncoder());
//	     
//	        return authProvider;
//	    }
//   

}
