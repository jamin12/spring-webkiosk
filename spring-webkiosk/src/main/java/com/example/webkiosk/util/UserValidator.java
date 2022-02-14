package com.example.webkiosk.util;

import com.example.webkiosk.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.thymeleaf.util.StringUtils;

@Component
public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }

    @Override
    public void validate(Object obj, Errors errors) {
        User user = (User) obj;
        if(StringUtils.isEmpty(user.getUserId())) {
            errors.rejectValue("user_id", "id.empty", "아이디를 입력하세요");
        }
    }
}
