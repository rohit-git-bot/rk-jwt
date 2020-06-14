package com.rk.jwt;

import java.security.Key;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@SpringBootApplication
public class JwtApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(JwtApplication.class, args);
		System.out.println("Rohit");
		Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
		String jws = Jwts.builder().setSubject("Rohit").signWith(key).compact();
		// Claims:
		// null - eyJhbGciOiJIUzI1NiJ9..4CEW08mxzL8rL0FNrix19SIqjvkFkSNaPcyDS3MpmNk
		// Rohit - eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJSb2hpdCJ9._SuR71ZZPH7zF_7PYPqy6w74tcQeHmkX6ZIp5khDFug
		// eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJSb2hpdCJ9.SQ7Kq4g29Z1XWq_8zGqDaVRvVYt9VzyX_n2e5B0cN6o

		System.out.println(jws);
	}

}
