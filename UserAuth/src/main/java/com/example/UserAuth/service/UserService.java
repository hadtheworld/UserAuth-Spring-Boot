package com.example.UserAuth.service;

import java.util.List;

import com.example.UserAuth.entities.LoginModel;
import com.example.UserAuth.entities.Users;

public interface UserService {
	public Users userLogin(LoginModel model);
	public Users addUsers(Users user);
	public List<Users> getUsers();
}
