package com.example.UserAuth.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.UserAuth.Exceptions.EmptyOutputException;
import com.example.UserAuth.Exceptions.UniqueValueException;
import com.example.UserAuth.dao.UserDao;
import com.example.UserAuth.entities.LoginModel;
import com.example.UserAuth.entities.Users;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@Override
	public List<Users> getUsers() {
//		fetch all the records from the table to show
		List<Users> user=this.userDao.findAll();
		if(user.isEmpty()) {
			throw new EmptyOutputException("No user in the database");
		}
		return user;
	}
	
	@Override
	public Users userLogin(LoginModel model) {
		// TODO Auto-generated method stub
		Users user=this.userDao.findByEmail(model.getEmailId());
		if(user==null) {
			throw new EmptyOutputException("user not found");
		}
		
		if (!passwordEncoder.matches(model.getPassword(), user.getPassword())) {
		    throw new IllegalArgumentException("wrong password");
		}

		return user;
	}

	
	@Override
	public Users addUsers(Users user) {
		// TODO Auto-generated method stub
		if(user == null) {
			
			throw new IllegalArgumentException("Request Body is missing");
		}
		if ((user.getFirstName()==null && user.getPassword()==null &&
	            user.getEmail()==null)) {
	        throw new IllegalArgumentException("User details are missing");
	    }
		if(user.getFirstName()==null || user.getFirstName().isBlank()
				 || user.getPassword()==null || user.getPassword().isBlank()
				|| user.getEmail()==null || user.getEmail().isBlank() 
				) {
			throw new IllegalArgumentException("first name, Email, and password cannot be empty" +user.getLastName());
		}
		if(this.userDao.findByEmail(user.getEmail())!=null) {
			
			throw new UniqueValueException("user email already in use");
		}
		user.setPassword(this.passwordEncoder.encode(user.getPassword()));
		this.userDao.save(user);
		return user;
	}

}
