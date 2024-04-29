package com.coin.info.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coin.info.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author liwei
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {
}
