package com.example.UserAuth.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.UserAuth.entities.Users;

@Repository
public interface UserDao extends JpaRepository<Users, Long>{

	public Users findByEmail(String userEmail);
}
