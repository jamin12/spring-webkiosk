package com.example.webkiosk.controller;

import com.example.webkiosk.entity.Category;
import com.example.webkiosk.entity.Option;
import com.example.webkiosk.entity.Product;
import com.example.webkiosk.entity.User;
import com.example.webkiosk.service.CategoryService;
import com.example.webkiosk.service.OptionService;
import com.example.webkiosk.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class KioskController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final OptionService optionService;

    @GetMapping("/kiosk")
    public String kiosk(Model model, HttpServletRequest request,
            @RequestParam(required = false) Long categoryId,
            @Qualifier("category") @PageableDefault(size = 5) Pageable categoryPage,
            @Qualifier("product") @PageableDefault(size = 8) Pageable productPage) {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        if (loginUser != null) {
            Page<Category> categories = categoryService.getCategories(loginUser.getUserNum(), categoryPage);
            Page<Product> products;

            if (categoryId != null) {
                products = productService.getProductsByCategoryId(categoryId, productPage);
                model.addAttribute("currentCategory", categoryId);
            } else {
                Long firstCategory = categoryService.getFirstCategoryId(loginUser.getUserNum());
                products = productService.getProductsByCategoryId(firstCategory, productPage);
                model.addAttribute("currentCategory", firstCategory);
            }

            model.addAttribute("loginUser", loginUser);
            model.addAttribute("category", new Category());
            model.addAttribute("categories", categories);
            model.addAttribute("products", products);

            return "kiosk/kiosk";
        } else {
            return "redirect:/login";
        }
    }

    /*
     * @GetMapping("/kiosk")
     * public String kiosk(Model model, HttpServletRequest request,
     * 
     * @Qualifier("category") @PageableDefault(size = 5) Pageable categoryPage,
     * 
     * @Qualifier("product") @PageableDefault(size = 8) Pageable productPage) {
     * HttpSession session = request.getSession();
     * User loginUser = (User) session.getAttribute("loginUser");
     * 
     * Map<String, ?> rttrMap = RequestContextUtils.getInputFlashMap(request);
     * 
     * if(loginUser != null) {
     * Page<Category> categories =
     * categoryService.getCategories(loginUser.getUserNum(), categoryPage);
     * Page<Product> products;
     * 
     * if(rttrMap != null) {
     * products = productService.getProductsByCategoryId((Long)
     * rttrMap.get("categoryId"), productPage);
     * model.addAttribute("currentCategory", (Long) rttrMap.get("categoryId"));
     * }else {
     * Long firstCategory =
     * categoryService.getFirstCategoryId(loginUser.getUserNum());
     * products = productService.getProductsByCategoryId(firstCategory,
     * productPage);
     * model.addAttribute("currentCategory", firstCategory);
     * }
     * 
     * model.addAttribute("loginUser", loginUser);
     * model.addAttribute("category", new Category());
     * model.addAttribute("categories", categories);
     * model.addAttribute("products", products);
     * 
     * return "kiosk/kiosk";
     * } else {
     * return "redirect:/login";
     * }
     * }
     */

    @PostMapping("/kiosk")
    public String kioskSubmit() {
        return "redirect:/kiosk";
    }
}
