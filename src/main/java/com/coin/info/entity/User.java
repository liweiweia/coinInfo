package com.coin.info.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class User {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    //加密后的字段
    private String password;
    private Integer age;
    private String email;
    // 省略其他字段
}
