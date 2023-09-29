package com.order.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.order.app.filter.JwtFilter;
import com.order.app.service.MyUserDetails;



@Configuration
public class SecurityConfig {


	 @Autowired
	 private MyUserDetails myUserDetails;
	 
	 @Autowired
	 private JwtFilter jwtFilter;   
	 
	 
	 
	 	@Bean
		protected AuthenticationManager authenticationManager
		        (AuthenticationConfiguration authConfig) throws Exception {
			
			return authConfig.getAuthenticationManager();	
			
	 	}
	 	
			@Bean
			public AuthenticationProvider getAuthProvider() {
				DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
				auth.setUserDetailsService(myUserDetails);
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
				
				.antMatchers(HttpMethod.GET,"/api/allorder").permitAll()
				.antMatchers(HttpMethod.POST,"/api/order/**").authenticated()             //authenticated()
				.antMatchers(HttpMethod.GET,"/api/allorder/**").authenticated()
				.antMatchers(HttpMethod.GET,"/api/allorder/byuser/**").authenticated() 
				.antMatchers(HttpMethod.GET,"/email/*").authenticated()
				
				.anyRequest().permitAll()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);
	
		return http.build();
			}
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
}

































































//
//	@Configuration
//	public class SecurityConfig {
//
//		@Autowired
//		private MyUserDetails myUserDetails;
//	 
//		 @Bean
//		    public UserDetailsService userDetailsService() {
//		        return new MyUserDetails();
//		    }
//		 
//		 @Bean
//		    public BCryptPasswordEncoder passwordEncoder() {
//		        return new BCryptPasswordEncoder();
//		    }
//		 
//		 @Bean
//		    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//				http.authorizeRequests()
//			 
//				.antMatchers(HttpMethod.GET,"/api/allorder").authenticated()
//				.antMatchers(HttpMethod.POST,"/api/order/**").permitAll()                //authenticated()
//				.antMatchers(HttpMethod.GET,"/api/allorder/**").authenticated()
//				.antMatchers(HttpMethod.GET,"/api/allorder/byuser/**").authenticated() 
//		
//				
//			
//				//.anyRequest().permitAll()
//				.and()
//				.httpBasic()
//				.and().csrf().disable()
//				.cors().disable();
//				
//				http.authenticationProvider(authenticationProvider());
//			 	return http.build();
//		    }
//		     
//		    @Bean
//		    public WebSecurityCustomizer webSecurityCustomizer() {
//		    	return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
//		         
//		    }
//		    @Bean
//		    public AuthenticationManager authenticationManager(
//		            AuthenticationConfiguration authConfig) throws Exception {
//		        return authConfig.getAuthenticationManager();
//		    }
//		    @Bean
//		    public DaoAuthenticationProvider authenticationProvider() {
//		        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//		         
//		        authProvider.setUserDetailsService(userDetailsService());
//		        authProvider.setPasswordEncoder(passwordEncoder());
//		     
//		        return authProvider;
//		    }
//	   
		

	



