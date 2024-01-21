package com.s13sh.bookmymovie.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;

import com.s13sh.bookmymovie.dao.UserDao;
import com.s13sh.bookmymovie.dto.User;
import com.s13sh.bookmymovie.helper.AES;

import jakarta.servlet.http.HttpSession;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDao dao;

    @Override
    public String signup(User user, BindingResult result, ModelMap map, HttpSession session) {
        if (dao.checkDuplicateEmail(user.getEmail()))
            result.rejectValue("email", "error.email", "* Account already exists with this Email address");
        if (dao.checkDuplicateMobile(user.getMobile()))
            result.rejectValue("mobile", "error.mobile", "* Account already exists with this Mobile Number");

        if (result.hasErrors())
            return "signup";
        else {
            user.setPassword(AES.encrypt(user.getPassword(), "123"));
            user.setRole("USER");
            dao.save(user);
            return "redirect:/login";
        }
    }

}
