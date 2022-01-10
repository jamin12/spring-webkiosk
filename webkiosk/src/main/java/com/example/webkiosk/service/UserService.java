package com.example.webkiosk.service;

import java.util.Optional;

import com.example.webkiosk.entity.User;

public interface UserService {
	public Boolean login(String id, String pw);
	public void registerUser(User vo);
}
