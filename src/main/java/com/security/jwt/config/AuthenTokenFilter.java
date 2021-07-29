package com.security.jwt.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import com.security.jwt.utils.JwtUtils;

public class AuthenTokenFilter extends OncePerRequestFilter {
	private static final Logger Logger = LoggerFactory.getLogger(AuthenTokenFilter.class);
@Autowired
private JwtUtils jwtutils;
@Autowired
private UserDetailsService userdetailsservice;
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String jwt=null;
		String bearerToken = request.getHeader("Authorization");
        // Kiểm tra xem header Authorization có chứa thông tin jwt không
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer ")) {
            jwt= bearerToken.substring(7,bearerToken.length());
        }
	try {
		if(jwt!=null && jwtutils.validateToken(jwt)) {
			String username=jwtutils.getUsernameFromtoken(jwt);
			UserDetails user=userdetailsservice.loadUserByUsername(username);
			
			UsernamePasswordAuthenticationToken auth=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
			auth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
			SecurityContextHolder.getContext().setAuthentication(auth);
		}
	}
	catch(Exception e) {
		Logger.error("loi khi xac thuc");
		e.printStackTrace();
	}
	filterChain.doFilter(request, response);
	
	}

}
