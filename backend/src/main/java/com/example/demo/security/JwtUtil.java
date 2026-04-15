package com.example.demo.security;

import io.jsonwebtoken.Claims;

import io.jsonwebtoken.Jwts;
import lombok.Value;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtil {

    // variables
    //generate token
    // extract token
    // validate token

    //1.variable declaration
    // Read secret key from application.properties
    @Value("${jwt.secret}")
    private String secretString;

    // Token valid for 7 days
    public final long EXPIRATION_MS =7*24*60*60*1000L;

    //"This converts string → key" (helper method)
    public SecretKey getKey(){
        return Keys.hmacShaKeyFor(secretString.getBytes());
    }

    // now generates the token  // Called after login/register — creates the token
    public String generateToken(String email){
        return Jwts.builder()
                .subject(email)
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+EXPIRATION_MS))
                .signWith(getKey())
                .compact();
    }

    // Called by JwtAuthFilter — reads email out of token
    public String extractEmail(String token)
    {
            return parseClaims(token).getSubject();
    }

    // Called by JwtAuthFilter — checks token is not expired
    public boolean isTokenValid(String token){
        try{
            return !parseClaims(token).getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }

    }
    //parseClaims() = decode token → get data inside it
    private Claims parseClaims(String token){
        return Jwts.parser()
                .verifyWith(getKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}