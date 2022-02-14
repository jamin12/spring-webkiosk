//강경민
package com.example.webkiosk.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.example.webkiosk.entity.Category;
import com.example.webkiosk.entity.User;
import com.example.webkiosk.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Service
public interface CategoryService {

    private final CategoryRepository categoryRepository;

    /**
     * 카테고리 목록 가져오기(페이지)
     */
    public Page<Category> getCategories(Long userNum, Pageable pageable) {
        Page<Category> categoryList = categoryRepository.getCategoriesByUserNum(userNum, pageable);
        if(categoryList == null) {
            throw new IllegalStateException("잘못된 호출입니다.");
        }
        return categoryList;
    }

    /**
     * 첫번째 카테고리 아이디 가져오기
     */
    public Long getFirstCategoryId(Long userNum) {
        Long firstCategory;
        if(categoryRepository.getCategoryIdList(userNum).isEmpty()) {
            firstCategory = 0L;
        } else {
            firstCategory = categoryRepository.getCategoryIdList(userNum).get(0);
        }
        return firstCategory;
    }

    /**
     * 회원 카테고리 정보 가져오기
     */
    public List<Category> getCategoryNames(Long userNum) {
        List<Category> categoryList = categoryRepository.getCategoryNamesByUserNum(userNum);
        if(categoryList == null) {
            throw new IllegalStateException("잘못된 호출입니다.");
        }
        return categoryList;
    }

    /**
     * 카테고리 등록
     */
    public void saveCategory(String categoryName, Long userNum) {
        Category category = new Category();

        category.setCategoryName(categoryName);
        category.setUserNum(userNum);
        categoryRepository.save(category);
    }
}
