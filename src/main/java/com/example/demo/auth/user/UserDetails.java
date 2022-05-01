package com.example.demo.auth.user;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

public interface UserDetails {
    // 사용자의 권한을 콜렉션 형태로 반환
    // 단, 클래스 자료형은 GrantedAuthority를 구현해야함
    Collection<? extends GrantedAuthority> getAuthorities();

    // 사용자의 id를 반환 (unique한 값)
    String getUsername();

    // 사용자의 password를 반환
    String getPassword();

    // 계정 만료 여부 반환
    boolean isAccountNonExpired();

    // 계정 잠금 여부 반환
    boolean isAccountNonLocked();

    // 패스워드의 만료 여부 반환
    boolean isCredentialsNonExpired();

    // 계정 사용 가능 여부 반환
    boolean isEnabled();
}
