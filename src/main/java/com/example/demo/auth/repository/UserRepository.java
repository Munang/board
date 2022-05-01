package com.example.demo.auth.repository;

import com.example.demo.auth.user.UserInfo;

import java.util.Optional;

public interface UserRepository {
    Optional<UserInfo> findByEmail(String email);

    Long save(UserInfo userInfo);

}
