//강경민
package com.example.webkiosk.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.webkiosk.entity.Category;
import com.example.webkiosk.entity.Option;
import com.example.webkiosk.entity.Product;
import com.example.webkiosk.repository.CategoryRepository;
import com.example.webkiosk.repository.OptionRepository;
import com.example.webkiosk.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final OptionRepository optionRepository;

    /**
     * 접속한 회원의 카테고리에 따른 상품 목록 가져오기
     */
    public List<Product> getProductsByCategoryId(Long categoryId) {
        List<Product> categoryProduct = productRepository.getProductsByCategoryId(categoryId);
        return categoryProduct;
    }

    public List<Category> getAllCategoryName(Long UserNum) {
        List<Category> list = categoryRepository.findByUserNum(UserNum);
        return list;
    }

    public List<Option> getAllOptionName(Long userNum) {
        // TODO Auto-generated method stub
        List<Option> list = optionRepository.findByUserNum(userNum);
        return list;
    }

    public void saveProduct(Product product) {
        // TODO Auto-generated method stub
        productRepository.save(product);
    }
}
