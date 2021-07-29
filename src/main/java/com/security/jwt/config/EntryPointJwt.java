package com.security.jwt.config;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class EntryPointJwt implements AuthenticationEntryPoint {
	private static final Logger Logger=LoggerFactory.getLogger(EntryPointJwt.class);
	@Override
	public void commence(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException authException) throws IOException, ServletException {
		Logger.error("loi jwt",authException.getMessage());
		response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "khong dc uy quyen" );
	}

}
