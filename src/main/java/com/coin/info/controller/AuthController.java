package com.coin.info.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.coin.info.entity.AuthenticationResponse;
import com.coin.info.entity.User;
import com.coin.info.service.UserService;
import com.coin.info.utils.JwtUtil;
import com.coin.info.utils.Result;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.security.sasl.AuthenticationException;

/**
 * @author liwei
 * @since 2024-04-29
 * <p>
 *     权限controller
 * </p>
 */
@RestController
public class AuthController {
    @Resource
    private AuthenticationManager authenticationManager;

    @Resource
    private JwtUtil jwtUtil;

    @Resource
    private UserService userService;

    @PostMapping("/api/auth/login")
    public Result<?> createAuthenticationToken(@RequestBody User authenticationRequest) {
        // 查询数据库，检查账号是否存在并验证密码是否正确
        User user = userService.getUserByNameAndPassword(authenticationRequest.getName(), authenticationRequest.getPassword());
        if (user == null) {
           return new Result<User>(500,"Invalid username or password",user);
        }


        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(authenticationRequest.getName(), authenticationRequest.getPassword())
        );
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final String jwt = jwtUtil.generateToken(authenticationRequest.getName());
        return new Result<>(200,"Success",new AuthenticationResponse(jwt));
    }
}
