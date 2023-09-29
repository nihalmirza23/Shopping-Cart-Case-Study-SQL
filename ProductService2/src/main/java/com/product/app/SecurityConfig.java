package com.product.app;

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

import com.product.app.jwtfilter.JwtFilter;
import com.product.app.service.MyUserDetails;



@Configuration
public class SecurityConfig {

	 
	 @Autowired
	 private MyUserDetails myUserDetails;
	 
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
				
				.antMatchers(HttpMethod.GET,"/product/allproduct").permitAll() 
				.antMatchers(HttpMethod.POST,"/product/allproduct/**").authenticated() //auth
				.antMatchers(HttpMethod.GET,"/product/allproduct/**").permitAll()
				.antMatchers(HttpMethod.GET,"/product/allproduct/type/**").permitAll()
				.antMatchers(HttpMethod.GET,"/product/allproduct/name/**").permitAll()
				.antMatchers(HttpMethod.GET,"/product/allproduct/category/**").permitAll()
				.antMatchers(HttpMethod.PUT,"/product/allproduct/**").authenticated()    //auy 
				.antMatchers(HttpMethod.DELETE,"/product/allproduct/**").authenticated() //auy 
				.antMatchers(HttpMethod.POST,"/category/addCategory").authenticated()    //auth
				.antMatchers(HttpMethod.GET,"/category/categories").permitAll()
				.antMatchers(HttpMethod.GET,"/category/category/**").permitAll()
				.antMatchers(HttpMethod.POST,"/review/postreview/**/**").permitAll()
				.antMatchers(HttpMethod.GET,"/category/user/login").authenticated()

				 
				.anyRequest().permitAll()
				.and()
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
	
		return http.build();
		
	}
				
				
				
				
				
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
	 
//	 @Bean
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//			http.authorizeRequests()
//		 
//			.antMatchers(HttpMethod.GET,"/product/allproduct").permitAll() 
//			.antMatchers(HttpMethod.POST,"/product/allproduct/**").permitAll() //auth
//			.antMatchers(HttpMethod.GET,"/product/allproduct/**").permitAll()
//			.antMatchers(HttpMethod.GET,"/product/allproduct/type/**").permitAll()
//			.antMatchers(HttpMethod.GET,"/product/allproduct/name/**").permitAll()
//			.antMatchers(HttpMethod.GET,"/product/allproduct/category/**").permitAll()
//			.antMatchers(HttpMethod.PUT,"/product/allproduct/**").authenticated() //auy 
//			.antMatchers(HttpMethod.DELETE,"/product/allproduct/**").permitAll() //auy 
//			
//			.antMatchers(HttpMethod.POST,"/category/addCategory").permitAll()////auth
//			.antMatchers(HttpMethod.GET,"/category/categories").permitAll()
//			.antMatchers(HttpMethod.GET,"/category/category/**").permitAll()
//			
//			.antMatchers(HttpMethod.POST,"/review/postreview/**/**").permitAll()
//			
//	        .anyRequest().permitAll()
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
  
	

}
