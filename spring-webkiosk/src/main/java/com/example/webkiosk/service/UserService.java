package com.example.webkiosk.service;

import com.example.webkiosk.entity.User;

public interface UserService {
	public Boolean login(String id, String pw);

	public void registerUser(User vo);

	public User findByUserId(String userId);

	public void setLoginUserInfo(User user);
}