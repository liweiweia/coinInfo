package com.coin.info.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.coin.info.entity.Article;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<Article> {
}
