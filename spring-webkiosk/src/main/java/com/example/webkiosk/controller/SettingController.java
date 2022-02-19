package com.example.webkiosk.controller;

import com.example.webkiosk.entity.Category;
import com.example.webkiosk.entity.FileDto;
import com.example.webkiosk.entity.Option;
import com.example.webkiosk.entity.Product;
import com.example.webkiosk.entity.User;
import com.example.webkiosk.service.CategoryService;
import com.example.webkiosk.service.OptionService;
import com.example.webkiosk.service.ProductService;
import com.example.webkiosk.util.FileUpload;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@RequiredArgsConstructor
@Controller
@Slf4j
@RequestMapping("/setting")
public class SettingController {

	private final CategoryService categoryService;
	private final ProductService productService;
	private final OptionService optionService;
	private FileUpload fileUpload;

	@GetMapping("/regCategory")
	public String regCategory(Model model, HttpServletRequest request) {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");

		if (loginUser != null) {
			List<Category> categories = categoryService.getCategoryNames(loginUser.getUserNum());

			model.addAttribute("categories", categories);
			model.addAttribute("category", new Category());
			return "setting/regCategory";
		} else {
			return "redirect:/login";
		}
	}

	@PostMapping("regCategory")
	public String regCategorySubmit(Model model, @ModelAttribute("category") Category category,
			HttpServletRequest request) {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		model.addAttribute("loginUser", loginUser);
		categoryService.saveCategory(category.getCategoryName(), loginUser.getUserNum());
		return "redirect:/setting/regCategory";
	}

	@PostMapping("/regProduct")
	public String regProductSubmit(@ModelAttribute("product") Product product, MultipartHttpServletRequest request)
			throws Exception {
		if (ObjectUtils.isEmpty(request)) {
			return "";
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginUser");
		fileUpload = new FileUpload();
		product.setProductImage(fileUpload.fileUpload(request, user, product.getProductName()));
		productService.saveProduct(product);
		return "setting/regProduct";
	}

	@PostMapping("/regOption")
	public String regOptionSubmit(@ModelAttribute("option") Option option, MultipartHttpServletRequest request)
			throws IllegalStateException, IOException {
		HttpSession session = request.getSession();
		User loginUser = (User) session.getAttribute("loginUser");
		fileUpload = new FileUpload();
		option.setOptionImage(fileUpload.fileUpload(request, loginUser, option.getOptionName()));
		optionService.saveOption(loginUser.getUserNum(), option.getOptionName(), option.getOptionPrice(),
				option.getOptionImage());
		return "setting/regOption";
	}

	@RequestMapping("deleteCategory")
	public String deleteCategory(@RequestParam("categoryId") Long categoryId) {
		if (categoryId == null) {
			return "redirect:/kiosk";
		} else {
			categoryService.deleteCategory(categoryId);
		}
		return "redirect:/setting/regCategory";
	}

	@GetMapping("/regOption")
	public String regOption() {
		return "setting/regOption";
	}

	@GetMapping("/regProduct")
	public String regProduct(Model model, HttpServletRequest request) {
		User usernum = (User) request.getSession().getAttribute("loginUser");
		List<Category> categoryList = productService.getAllCategoryName(usernum.getUserNum());
		List<Option> optionList = productService.getAllOptionName(usernum.getUserNum());
		model.addAttribute("option", optionList);
		model.addAttribute("categories", categoryList);
		return "setting/regProduct";
	}

	@GetMapping("/modProduct")
	public String modProduct() {
		return "setting/modProduct";
	}
}
