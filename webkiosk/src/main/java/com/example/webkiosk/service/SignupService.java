package com.example.webkiosk.service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;

import com.example.webkiosk.entity.User;
import com.example.webkiosk.hash.ExtractHash;
import com.example.webkiosk.repository.SignupRepository;

@Service
@Transactional
public class SignupService {

	@Autowired
	private SignupRepository signupRepository;

	public void registerUser(User vo) { // 컨트롤러에서 넘어온 오브젝트를 vo로 담고 
		User user = new User(); // user 오브젝트에 각자 담는다.
		ExtractHash extractHash = new ExtractHash();
		user.setUserid(vo.getUserid());
		user.setUserpw(extractHash.ExtractSHA256(vo.getUserpw()));
		user.setUsername(vo.getUsername());
		user.setUsercompany(vo.getUsercompany());
		user.setMobile(vo.getMobile());
		user.setEmail(vo.getEmail()); 
		signupRepository.save(user); // 데이터베이스 전송
	}

//	public Map<String, String> validateHandling(Errors errors) { //validation 작업하다가 멈춤
//		Map<String, String> validatorResult = new HashMap<>();
//		for(FieldError error : errors.getFieldErrors()) {
//			String validKeyName = String.format("valid_%s", error.getField());
//			validatorResult.put(validKeyName, error.getDefaultMessage());
//		}
//		return validatorResult;
//	}
}
