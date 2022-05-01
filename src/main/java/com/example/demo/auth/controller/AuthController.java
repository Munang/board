package com.example.demo.auth.controller;
import com.example.demo.auth.service.UserService;
import com.example.demo.auth.user.UserInfoDto;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@AllArgsConstructor
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;

    @PostMapping("/user")
    public String signup(@RequestBody UserInfoDto infoDto) { // 회원 추가
        userService.save(infoDto);
        return "test success";
    }


    // 추가
    @GetMapping(value = "/logout")
    public String logoutPage(HttpServletRequest request, HttpServletResponse response) {
        new SecurityContextLogoutHandler().logout(request, response, SecurityContextHolder.getContext().getAuthentication());
        return "logout test success";
    }
}