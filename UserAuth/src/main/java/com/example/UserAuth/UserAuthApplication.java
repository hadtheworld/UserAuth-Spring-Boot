package com.example.UserAuth;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.UserAuth.dao.UserDao;
import com.example.UserAuth.entities.Users;

import jakarta.annotation.PostConstruct;

@SpringBootApplication
public class UserAuthApplication {
	@Autowired
	private UserDao userDao;
	private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	@PostConstruct
	public void initUsers() {
		List<Users> users=Stream.of(
				new Users(1,"God","jesus","God@email.com",passwordEncoder.encode("godly")),
				new Users(2,"Devil","satan","devil@email.com",passwordEncoder.encode("devily")))
				.collect(Collectors.toList());
		this.userDao.saveAll(users);
	}
	public static void main(String[] args) {
		SpringApplication.run(UserAuthApplication.class, args);
	}

}
