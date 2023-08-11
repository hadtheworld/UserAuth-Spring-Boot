package com.example.UserAuth.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserAuth.entities.LoginModel;
import com.example.UserAuth.entities.Users;
import com.example.UserAuth.service.UserService;



@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping
	public ResponseEntity<List<Users>> getUserList(){
		return new ResponseEntity<>(userService.getUsers(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Users> addUser(@RequestBody(required=false) Users user) {
		return new ResponseEntity<>(this.userService.addUsers(user),HttpStatus.OK);
	}
	
	@PostMapping("/login")
	public ResponseEntity<Users> userLogin(@RequestBody LoginModel model){

		Users user=this.userService.userLogin(model);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
}
