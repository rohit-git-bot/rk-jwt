package com.rk.jwt.service;

import java.util.ArrayList;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class JwtUserDetailsService implements UserDetailsService{

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if ("rohit".equals(username)) {
			return new User("rohit", "$2a$10$99zghU5/VDp4EfOzsg32tusqz4K51O8ipWi3XWjW5hSw3AQ7UGlqW", new ArrayList<>());
		}
		else {
			throw new UsernameNotFoundException(username +" not found");
		}
	}

}
