//package com.coin.info.controller;
//
//import com.coin.info.entity.User;
//import com.coin.info.service.UserService;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.bind.annotation.*;
//
//import javax.annotation.Resource;
//
//
///**
// * @author liwei
// */
//@RestController
//@RequestMapping("/user")
//public class UserController {
//
//    @Resource
//    private UserService userService;
//
//    @Resource
//    private PasswordEncoder passwordEncoder;
//    /**
//     * 用户注册
//     * @param user
//     * @return
//     */
//    @PostMapping("/register")
//    public ResponseEntity<?> registerUser(@RequestBody User user) {
//        user.setPassword(passwordEncoder.encode(user.getPassword()));
//        userService.save(user);
//        return ResponseEntity.ok("User registered successfully");
//    }
//
//
//    @GetMapping("/{id}")
//    public User getUserById(@PathVariable Long id) {
//        return userService.getById(id);
//    }
//
//    @PostMapping("/create")
//    public User createUser(@RequestBody User user) {
//        userService.save(user);
//        return user;
//    }
//
//    @PutMapping("/update")
//    public boolean updateUser(@RequestBody User user) {
//        return userService.updateById(user);
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public boolean deleteUser(@PathVariable Long id) {
//        return userService.removeById(id);
//    }
//}
