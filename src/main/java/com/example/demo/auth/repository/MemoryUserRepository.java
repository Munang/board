package com.example.demo.auth.repository;

import com.example.demo.auth.user.UserInfo;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

//컴포넌트라고 해야 자동으로 주입?

@Component
public class MemoryUserRepository implements UserRepository{

    Map<String, UserInfo> memberHashMap = new HashMap<>();
    Integer sequence = 0;

    public Long save(UserInfo userInfo){
        memberHashMap.put(String.valueOf(sequence++), userInfo);
        return sequence.longValue();
    }
    @Override
    public Optional<UserInfo> findByEmail(String email) {
        return Optional.empty();
    }
    //Optional이 머야??
}
