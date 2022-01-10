package com.example.webkiosk.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.webkiosk.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	public User findByUserid(String userid);
}
