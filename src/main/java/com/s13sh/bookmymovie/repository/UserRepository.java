package com.s13sh.bookmymovie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.s13sh.bookmymovie.dto.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    boolean existsByEmail(String email);

    boolean existsByMobile(long mobile);

    User findByEmail(String email);

}
