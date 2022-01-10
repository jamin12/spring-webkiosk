package com.example.webkiosk.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.webkiosk.entity.User;
import com.example.webkiosk.repository.UserRepository;
import com.example.webkiosk.service.UserService;
import com.example.webkiosk.service.UserServiceImpl;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class WebkisokController {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login() {
		return "login";
	}
	
	@PostMapping("/login")
	public String loginSubmit(@ModelAttribute("login") User user) {
		if(userService.login(user.getUserid(), user.getUserpw())) {
			return "redirect:/success";
		} else {
			return "redirect:/fail";
		}
	}

	@GetMapping("/signup")
	public String signup(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	@PostMapping("/signup")
	public String signUpSubmit(@Valid User user, Errors errors, Model model) {
		if(userRepository.findByUserid(user.getUserid()) == null) { // 아이디로 검색해서 널 값일경우 서비스실행
			userService.registerUser(user);
			return "redirect:/login";
		} else {
            return "redirect:/signup";
		}
	}
}
