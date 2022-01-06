package com.example.webkiosk.repository;

import org.springframework.data.repository.CrudRepository;

import com.example.webkiosk.entity.Users;

public interface UsersRepository extends CrudRepository<Users, Integer> {

}
