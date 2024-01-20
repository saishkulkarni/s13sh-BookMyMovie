package com.s13sh.bookmymovie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GeneralController {

    @GetMapping("/")
    public String loadHome() {
        return "home";
    }

    @GetMapping("/login")
    public String loadLogin() {
        return "login";
    }

    @GetMapping("/signup")
    public String loadSignup() {
        return "signup";
    }

}
