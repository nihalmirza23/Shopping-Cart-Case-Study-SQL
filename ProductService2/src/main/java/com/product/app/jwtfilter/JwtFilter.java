package com.product.app.jwtfilter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.product.app.jwtutil.JwtUtil;
import com.product.app.service.MyUserDetails;





@Component
public class JwtFilter extends OncePerRequestFilter{

	 @Autowired
	 private MyUserDetails myUserDetails;
	 

	 @Autowired
	 private JwtUtil  jwtUtil;
	 
	 
	 @Override
		protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
				throws ServletException, IOException {
			// TODO Auto-generated method stub
			
			final String authorizationHeader=request.getHeader("Authorization");
			
			String username=null;
			String jwt=null;
			
			if(authorizationHeader!=null && authorizationHeader.startsWith("Bearer ")) {
				jwt = authorizationHeader.substring(7);
				username = jwtUtil.extractUsername(jwt);
			}
			
			if(username!=null && SecurityContextHolder.getContext().getAuthentication()==null) {
				UserDetails userDetails = this.myUserDetails.loadUserByUsername(username);
				
				if(jwtUtil.validateToken(jwt, userDetails)) {
					UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken
														(userDetails, null,userDetails.getAuthorities());
					
					authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
					SecurityContextHolder.getContext().setAuthentication(authenticationToken);
				}
			}
			
			filterChain.doFilter(request, response);
			
		}
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
	 
}
