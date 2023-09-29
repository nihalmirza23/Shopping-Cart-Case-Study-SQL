package com.wallet.api;

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

import com.wallet.api.jwtfilter.JwtFilter;
import com.wallet.api.service.MyUserDetails;





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
			
	 
//	 @Bean
//	    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//			http.authorizeRequests()
//		 
//			.antMatchers(HttpMethod.GET,"/api/wallets").permitAll()
//			.antMatchers(HttpMethod.POST,"/api/wallet/**").permitAll()
//			.antMatchers(HttpMethod.POST,"/api/add/wallet/**/**").permitAll()
//			.antMatchers(HttpMethod.GET,"/api/wallets/**").permitAll()
//			.antMatchers(HttpMethod.GET,"/api/pay/byWallet/**/**").permitAll()
//			.antMatchers(HttpMethod.GET,"/api/payment/history/**").permitAll()
//			
//		
//			//.anyRequest().permitAll()
//			.and()
//			.httpBasic()
//			.and().csrf().disable()
//			.cors().disable();
//			http.authenticationProvider(authenticationProvider());
//		 	return http.build();
//	    }
			@Bean
			public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
				
				http.authenticationProvider(getAuthProvider());
				http.csrf().disable().authorizeRequests()
			    .antMatchers(HttpMethod.GET,"/api/wallets").authenticated()
				.antMatchers(HttpMethod.POST,"/api/wallet/*").authenticated()
				.antMatchers(HttpMethod.POST,"/api/add/wallet/*/*").authenticated()
				.antMatchers(HttpMethod.GET,"/api/wallets/*").authenticated()
				.antMatchers(HttpMethod.GET,"/api/pay/byWallet/*/*").authenticated()
				.antMatchers(HttpMethod.GET,"/api/payment/history/*").authenticated()
									
						
						.anyRequest().authenticated()
						.and()
						.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
				
				http.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
			
				return http.build();
				
			}
			
	 
	 
	     
	
   
	

}
