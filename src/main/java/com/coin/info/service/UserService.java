package com.coin.info.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coin.info.entity.User;
import com.coin.info.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liwei
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User> {

    @Resource
    private UserMapper userMapper;
    // 查询数据库，检查账号是否存在并验证密码是否正确
    public User getUserByNameAndPassword(String name, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("name", name);
        queryWrapper.eq("password", password); // 这里假设密码明文存储，实际应该使用加密存储并比较加密后的值

        return userMapper.selectOne(queryWrapper);
    }
}
