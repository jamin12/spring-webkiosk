
package com.example.webkiosk.service;

import javax.transaction.Transactional;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.webkiosk.entity.User;
import com.example.webkiosk.repository.UserRepository;
import com.example.webkiosk.security.ExtractHash;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService {

	private final UserRepository userRepository;

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
		user.setUserBirthday(vo.getUserBirthday());
		userRepository.save(user);
	}

	@Override
	public User findByUserId(String userId){
		return userRepository.findByUserId(userId);
	}

	@Override
	public void setLoginUserInfo(User user) {
		User loginUser = userRepository.getUserByUserId(user.getUserId());

		user.setUserNum(loginUser.getUserNum());
		user.setUserName(loginUser.getUserName());
		user.setUserCompany(loginUser.getUserCompany());
		user.setUserBirthday(loginUser.getUserBirthday());
		user.setUserPhoneNumber(loginUser.getUserPhoneNumber());
		user.setUserEmail(loginUser.getUserEmail());
	}
}