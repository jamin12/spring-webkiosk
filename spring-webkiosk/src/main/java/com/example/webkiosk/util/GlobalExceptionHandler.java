package com.example.webkiosk.util;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler(value = { CustomException.class })
    protected String handleCustomException(CustomException e, Model model) {
        log.error("handleCustomException throw CustomException : {}", e.getErrorCode());
        model.addAttribute("errorMessage", e.getErrorCode());
        System.out.println(e.getErrorCode().getHttpStatus().value());
        switch (e.getErrorCode().getHttpStatus().value()) {
            case 404:
                return "error/fail";
            case 500:
                return "error/fail";
        }
        return "error/fail";
    }
}
