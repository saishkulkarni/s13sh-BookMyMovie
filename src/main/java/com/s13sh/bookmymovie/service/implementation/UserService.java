package com.s13sh.bookmymovie.service.implementation;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.s13sh.bookmymovie.dto.User;

import jakarta.servlet.http.HttpSession;

public interface UserService {
    public String signup(User user, BindingResult result, ModelMap map, HttpSession session);

    public String login(String email, String password, HttpSession session);
}
