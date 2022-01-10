package com.example.webkiosk.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webkiosk.entity.User;
import com.example.webkiosk.hash.ExtractHash;
import com.example.webkiosk.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public Boolean login(String id, String pw) {
		User user = userRepository.findByUserid(id);
		if (userRepository.findByUserid(id) == null) {
			return false;
		} else {
			ExtractHash extractHash = new ExtractHash();
			if (user.getUserpw().equals(extractHash.ExtractSHA256(pw))) {
				return true;
			} else {
				return false;
			}
		}
	}

	@Override
	public void registerUser(User vo) {
		User user = new User();
		ExtractHash extractHash = new ExtractHash();
		user.setUserid(vo.getUserid());
		user.setUserpw(extractHash.ExtractSHA256(vo.getUserpw()));
		user.setUsername(vo.getUsername());
		user.setUsercompany(vo.getUsercompany());
		user.setMobile(vo.getMobile());
		user.setEmail(vo.getEmail());
		userRepository.save(user);
	}
}
