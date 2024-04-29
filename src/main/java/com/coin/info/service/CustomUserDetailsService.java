package com.coin.info.service;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 在这里添加实际的用户查找逻辑
        if ("admin".equals(username)) {
            return new User(
                    "admin",
                    "{noop}password",  // {noop}表示使用明文密码，实际生产中应使用加密密码
                    Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))
            );
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}
