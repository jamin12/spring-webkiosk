package com.example.webkiosk.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webkiosk.entity.User;

@Repository
public interface SignupRepository extends JpaRepository<User, Integer>{
	public User findByUserid(String userid); // select * from test2 where user_id = 'parameter';
}