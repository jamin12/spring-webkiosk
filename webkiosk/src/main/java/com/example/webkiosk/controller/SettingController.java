package com.example.webkiosk.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/setting")
public class SettingController {

    @GetMapping("/regCategory")
    public String regCategory() {
        return "setting/regCategory";
    }

    @GetMapping("/regOption")
    public String regOption() {
        return "setting/regOption";
    }

    @GetMapping("/regProduct")
    public String regProduct() {
        return "setting/regProduct";
    }

    @GetMapping("/modProduct")
    public String modProduct() {
        return "setting/modProduct";
    }
}
