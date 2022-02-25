package com.example.webkiosk.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import com.example.webkiosk.util.CustomException;
import com.example.webkiosk.util.ErrorCode;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebErrorController implements ErrorController {
    @GetMapping("/error")
    public String errorHandler(HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            throw new CustomException(ErrorCode.PAGE_NOT_FOUND);
        }
        throw new CustomException(ErrorCode.INTERNAL_ERROR);
    }
}
