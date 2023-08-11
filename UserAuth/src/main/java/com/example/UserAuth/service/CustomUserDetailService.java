package com.example.UserAuth.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.example.UserAuth.Exceptions.EmptyOutputException;
import com.example.UserAuth.dao.UserDao;
import com.example.UserAuth.entities.Users;

@Service
public class CustomUserDetailService implements UserDetailsService{
	@Autowired
	private UserDao userDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		Users user=this.userDao.findByEmail(username);
		if(user==null) {
			throw new EmptyOutputException("user not found");
		}
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
	}
}
