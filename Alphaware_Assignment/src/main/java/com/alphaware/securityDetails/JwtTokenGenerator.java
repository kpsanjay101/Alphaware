package com.alphaware.securityDetails;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenGenerator extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication() ;
		System.out.println(authentication);
		if(authentication != null) {
			SecretKey key = Keys.hmacShaKeyFor(SecurityDetails.JWT_KEY.getBytes()) ;
			String jwt = Jwts.builder()
					.setIssuer("Sanjay")
					.setSubject("JWT_Token")
					.claim("email", authentication.getName()) 
					.claim("authorities", getValue(authentication.getAuthorities())) 
					.setIssuedAt(new Date())
					.setExpiration(new Date( new Date().getTime()+20000000))
					.signWith(key).compact() ;
			response.setHeader(SecurityDetails.JWT_HEADER, jwt);
		}
		else {
			System.out.println("something went wrong");
		}
		
		filterChain.doFilter(request, response);
		
	}
	
	public String getValue(Collection<? extends GrantedAuthority> collection) {
		Set<String> set = new HashSet<>() ;
		for(GrantedAuthority autho : collection) {
			set.add(autho.getAuthority()) ;
		}
		
		return String.join(",", set) ;
	}
	
	@Override
	protected  boolean shouldNotFilter(HttpServletRequest http){
		return ! http.getServletPath().equals("/api/users/logini") ;
	}

}