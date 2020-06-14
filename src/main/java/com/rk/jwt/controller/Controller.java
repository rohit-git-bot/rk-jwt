package com.rk.jwt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rk.jwt.pojo.UserInfo;
import com.rk.jwt.service.JwtUserDetailsService;
import com.rk.jwt.util.JwtUtil;

@RestController
@CrossOrigin
public class Controller {
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtUserDetailsService userDetailsService;
	
	@RequestMapping("/test")
	public String test() {
		return "Rohit";
	}
	
	@PostMapping(value = "/authenticate")
	public ResponseEntity<String> authenticate(@RequestBody UserInfo user) {
		String token = null;
		try {
			//authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUname(), user.getPwd()));
			UserDetails userDetails = userDetailsService.loadUserByUsername(user.getUname());
			token = jwtUtil.generateToken(userDetails);
		} catch (UsernameNotFoundException e) {
			e.printStackTrace();
			throw e;
		} catch (AuthenticationException e) {
			e.printStackTrace();
			throw e;
		}
		return ResponseEntity.ok(token);
	}
}
