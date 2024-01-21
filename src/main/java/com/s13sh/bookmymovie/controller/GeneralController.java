package com.s13sh.bookmymovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.s13sh.bookmymovie.dto.User;

import jakarta.validation.Valid;

@Controller
public class GeneralController {

    @Autowired
    User user;

    @GetMapping("/")
    public String loadHome() {
        return "home";
    }

    @GetMapping("/login")
    public String loadLogin() {
        return "login";
    }

    @GetMapping("/signup")
    public String loadSignup(ModelMap map) {
        map.put("user", user);
        return "signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid User user, BindingResult result) {
        if (result.hasErrors())
            return "Signup";
        else
            return "redirect:/login";
    }

}
