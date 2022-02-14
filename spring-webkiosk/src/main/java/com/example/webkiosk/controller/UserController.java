package com.example.webkiosk.controller;

import com.example.webkiosk.entity.User;
import com.example.webkiosk.repository.UserRepository;
import com.example.webkiosk.service.CategoryService;
import com.example.webkiosk.service.UserService;
import com.example.webkiosk.util.UserValidator;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService userService;
    private final UserValidator userValidator;

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("login", new User());
        return "/user/login";
    }

    @PostMapping("/login")
    public String loginSubmit(User user, HttpServletRequest request) {

        if (userService.login(user.getUserId(), user.getUserPassword())) {
            userService.setLoginUserInfo(user);
            HttpSession session = request.getSession();
            session.setAttribute("loginUser", user);

            return "redirect:/kiosk";
        } else {
            return "redirect:/fail";
        }
    }

    @GetMapping("/signup")
    public String signup(Model model) {
        model.addAttribute("user", new User());
        return "user/signup";
    }

    @PostMapping("/signup")
    public String signUpSubmit(@Valid User user, Errors errors) {
        if (userService.findByUserId(user.getUserId()) == null) { // 아이디로 검색해서 널 값일경우 서비스실행
            userService.registerUser(user);
            return "redirect:/login";
        } else {
            return "redirect:/signup";
        }
    }
}
