package com.alphaware.securityDetails;

import java.io.IOException;

import javax.crypto.SecretKey;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenValidator extends OncePerRequestFilter{

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String jwt= request.getHeader(SecurityDetails.JWT_HEADER);
		if(jwt != null) {
			try {
				jwt = jwt.substring(7);
				SecretKey key= Keys.hmacShaKeyFor(SecurityDetails.JWT_KEY.getBytes());
				Claims claims= Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(jwt).getBody();
				String username= String.valueOf(claims.get("email"));
				String authorities = (String) claims.get("authorities");
				UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(username, null, AuthorityUtils.commaSeparatedStringToAuthorityList(authorities));
				SecurityContextHolder.getContext().setAuthentication(auth);
			} catch (Exception e) {
				throw new BadCredentialsException("Invalid Token received..");
			}
						
		}
		filterChain.doFilter(request, response);
		
	}
	
	@Override
	public boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
		return request.getServletPath().equals("/api/users/login");
	}

}
