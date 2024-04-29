package com.coin.info.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coin.info.entity.User;
import com.coin.info.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @author liwei
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {
}
