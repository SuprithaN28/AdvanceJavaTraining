package com.training.advancedJava.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

import java.util.Date;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class JwtUtil {

    // private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    private static final String SECRETKEY = "mysecretkeyforjavaadvancedtrainingduringbenchperiod";

    public static String generateToken(String username) {
        return Jwts.builder().setSubject(username).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))       //1 hr
                .signWith(SignatureAlgorithm.HS256, SECRETKEY).compact();
    }

    public static boolean validateToken(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(SECRETKEY).build().parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

//    public String extractUsername(String token) {
//        return Jwts.parserBuilder()
//                .setSigningKey(SECRET_KEY)
//                .build()
//                .parseClaimsJws(token)
//                .getBody()
//                .getSubject();
//
//    }
}
