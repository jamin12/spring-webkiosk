package com.example.webkiosk.controller;

import java.util.Iterator;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.BindingResultUtils;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.webkiosk.entity.User;
import com.example.webkiosk.repository.SignupRepository;
import com.example.webkiosk.service.SignupService;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebkisokController {
	
	@Autowired
	private SignupRepository SignupRepository;
	@Autowired
	private SignupService signupService;

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("user", new User());
		return "login";
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/signup")
	public String signUpSubmit(@Valid User user, Errors errors, Model model) {
		if(SignupRepository.findByUserid(user.getUserid()) == null) { // 아이디로 검색해서 널 값일경우 서비스실행
			signupService.registerUser(user);
			return "redirect:/login";
		} else { /*아이디 검색해서 널값이 아니다 = 아이디가 존재한다 -> redirect > signup */

//			model.addAttribute("user", user); //	validation 제작하다가 작업멈춤 
//            Map<String, String> validatorResult = signupService.validateHandling(errors);
//            for (String key : validatorResult.keySet()) {
//                model.addAttribute(key, validatorResult.get(key));
//            }
//			model.addAttribute(user);
            return "redirect:/signup";
		}
	}
}
