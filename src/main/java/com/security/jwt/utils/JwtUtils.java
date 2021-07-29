package com.security.jwt.utils;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
@Component
public class JwtUtils {

private static final Logger Logger=LoggerFactory.getLogger(JwtUtils.class);
private String key="1111111111111";
private static final long expire=604800000L;

public String generateJwtToken(Authentication authentication) {
	UserDetails user=(UserDetails) authentication.getPrincipal();
	Date now=new Date();
	return Jwts.builder()
            .setSubject((user.getUsername()))
            .setIssuedAt(now)
            .setExpiration(new Date(now.getTime()+expire))
            .signWith(SignatureAlgorithm.HS512, key)
            .compact();
}
public String getUsernameFromtoken(String token) {
	return Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody().getSubject();
}


public boolean validateToken(String token) {
	try {
        Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        return true;
    } catch (MalformedJwtException ex) {
        System.out.println("Invalid JWT token");
    } catch (ExpiredJwtException ex) {
    	 System.out.println("Expired JWT token");
    } catch (UnsupportedJwtException ex) {
    	 System.out.println("Unsupported JWT token");
    } catch (IllegalArgumentException ex) {
    	 System.out.println("JWT claims string is empty.");
    }
    return false;
}

}
