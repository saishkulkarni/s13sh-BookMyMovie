package com.s13sh.bookmymovie.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.s13sh.bookmymovie.dto.User;
import com.s13sh.bookmymovie.repository.UserRepository;

@Repository
public class UserDao {

    @Autowired
    UserRepository repository;

    public User save(User user) {
        return repository.save(user);
    }

    public boolean checkDuplicateEmail(String email) {
        return repository.existsByEmail(email);
    }

    public boolean checkDuplicateMobile(long mobile) {
        return repository.existsByMobile(mobile);
    }

    public User findByEmail(String email) {
        return repository.findByEmail(email);
    }

}
