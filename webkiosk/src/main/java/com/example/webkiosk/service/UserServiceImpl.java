
package com.example.webkiosk.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webkiosk.entity.User;
import com.example.webkiosk.repository.UserRepository;
import com.example.webkiosk.security.ExtractHash;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public Boolean login(String id, String pw) {
		User user = userRepository.findByUserId(id);
		if (userRepository.findByUserId(id) == null) {
			return false;
		} else {
			ExtractHash extractHash = new ExtractHash();
			if (user.getUserPassword().equals(extractHash.ExtractSHA256(pw))) {
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
		user.setUserId(vo.getUserId());
		user.setUserPassword(extractHash.ExtractSHA256(vo.getUserPassword()));
		user.setUserName(vo.getUserName());
		user.setUserCompany(vo.getUserCompany());
		user.setUserPhoneNumber(vo.getUserPhoneNumber());
		user.setUserEmail(vo.getUserEmail());
		user.setUserBirthday("1900-01-01");
		user.setUserDiallingCode("01011111111");
		userRepository.save(user);
	}
}