package com.example.webkiosk.service;

import java.util.List;

import javax.transaction.Transactional;

import com.example.webkiosk.entity.Category;
import com.example.webkiosk.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;

    // id에 대응하는 카테고리 리턴
    public Category show(Integer id) {
        return categoryRepository.findById(id).orElse(null);
    }

    // 카테고리 전부 가져오기
    public List<Category> showAll(Integer user_id) {
        return categoryRepository.findByuserNum(user_id);
    }

    // 카테고리 생성
    @Transactional
    public Category Create(Category newCategory) {
        Category success = categoryRepository.save(newCategory);
        log.info("생성이 완료 되었습니다." + success.toString());
        return success;
    }

    // 카테고리 수정
    @Transactional
    public Category Updtae(Integer id, Category upCategory) {
        Category target = categoryRepository.findById(id).orElse(null);

        if (target == null || id != upCategory.getCategoryId()) {
            log.info("잘못된 요청 입니다.", id, upCategory.toString());
            return null;
        }
        target.patch(upCategory);
        Category successUpCategory = categoryRepository.save(target);
        log.info("수정이 완료 되었습니다.");
        return successUpCategory;
    }

    // 카테고리 삭제
    @Transactional
    public Category Delete(Integer id) {
        Category target = categoryRepository.findById(id).orElse(null);
        if (target == null) {
            log.info("지울 수 있는 대상이 없습니다.");
            return null;
        }
        categoryRepository.delete(target);
        log.info("삭제가 완료 되었습니다.");
        return target;
    }

}
