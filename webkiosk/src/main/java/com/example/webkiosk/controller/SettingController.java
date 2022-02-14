package com.example.webkiosk.controller;

import com.example.webkiosk.entity.Category;
import com.example.webkiosk.entity.Product;
import com.example.webkiosk.entity.User;
import com.example.webkiosk.service.CategoryService;
import com.example.webkiosk.service.ProductService;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/setting")
public class SettingController {

    private final CategoryService categoryService;
    private final ProductService productService;
    @GetMapping("/regCategory")
    public String regCategory(Model model, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        if(loginUser != null) {
            List<Category> categories = categoryService.getCategoryNames(loginUser.getUserNum());

            model.addAttribute("categories", categories);
            return "setting/regCategory";
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/regOption")
    public String regOption() {
        return "setting/regOption";
    }

    @GetMapping("/regProduct")
    public String regProduct(Model model, HttpServletRequest request) {
        User usernum = (User) request.getSession().getAttribute("loginUser");
        List<Category> categoryList = productService.getAllCategoryName(usernum.getUserNum());
        model.addAttribute("categories", categoryList);
        return "setting/regProduct";
    }

    @GetMapping("/modProduct")
    public String modProduct() {
        return "setting/modProduct";
    }
}
