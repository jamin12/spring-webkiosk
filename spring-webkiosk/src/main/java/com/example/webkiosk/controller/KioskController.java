package com.example.webkiosk.controller;

import com.example.webkiosk.entity.*;
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
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RequiredArgsConstructor
@Controller
public class KioskController {

    private final ProductService productService;
    private final CategoryService categoryService;
    private final OptionService optionService;

    @GetMapping("/kiosk")
    public String kiosk(Model model, HttpServletRequest request,
                        @Qualifier("category") @PageableDefault(size = 5) Pageable categoryPage) {
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        Map<String, ?> rttrMap = RequestContextUtils.getInputFlashMap(request);

        if(loginUser != null) {
            Page<Category> categories = categoryService.getCategories(loginUser.getUserNum(), categoryPage);
            List<Product> products;

            if(rttrMap != null) {
                products = productService.getProductsByCategoryId((Long) rttrMap.get("categoryId"));
                model.addAttribute("currentCategory", rttrMap.get("categoryId"));
            }else {
                Long firstCategory = categoryService.getFirstCategoryId(loginUser.getUserNum());
                products = productService.getProductsByCategoryId(firstCategory);
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

    @PostMapping("/kiosk")
    public String kioskSubmit(@RequestParam("cid") Long categoryId,
                              @RequestParam("page") Pageable categoryPage,
                              RedirectAttributes rttr) {
        rttr.addFlashAttribute("categoryId",categoryId);
        rttr.addFlashAttribute("categoryPage",categoryPage);
        return "redirect:/kiosk";
    }

    /*
    @PostMapping(value = "/callMenu")
    @ResponseBody
    public List<Product> callMenu(@RequestParam("cid") Long categoryId){
        List<Product> products = productService.getProductsByCategoryId(categoryId);
        return products;
    }
    */

    @PostMapping(value = "/callOption")
    @ResponseBody
    public List<Option> callOption(@RequestParam("pid") Long productId, HttpServletRequest request){
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");
        List<Option> options = optionService.getOptionByProductIdAndUserNum(productId, loginUser.getUserNum());
        return options;
    }
}
