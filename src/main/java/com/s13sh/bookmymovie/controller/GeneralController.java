package com.s13sh.bookmymovie.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.s13sh.bookmymovie.dto.User;
import com.s13sh.bookmymovie.service.implementation.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class GeneralController {

    @Autowired
    User user;

    @Autowired
    UserService service;

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
    public String signup(@Valid User user, BindingResult result, ModelMap map, HttpSession session) {
        if (result.hasErrors())
            return "Signup";
        else
            return service.signup(user, result, map, session);

    }

    @PostMapping("/login")
    public String login(@RequestParam String email, @RequestParam String password, HttpSession session) {
        return service.login(email, password, session);
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        session.setAttribute("successMessage", "Logout Successfully");
        return "redirect:/";
    }
}
