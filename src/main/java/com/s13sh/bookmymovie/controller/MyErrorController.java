package com.s13sh.bookmymovie.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MyErrorController implements ErrorController {

    @RequestMapping("/error")
    public String errorHandler(HttpServletRequest request) {

        int statusCode = (int) request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (statusCode == 404)
            return "404";
        else
            return "error";
    }

}
