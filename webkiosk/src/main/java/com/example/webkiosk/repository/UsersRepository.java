package com.example.webkiosk.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.webkiosk.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer> {

}
