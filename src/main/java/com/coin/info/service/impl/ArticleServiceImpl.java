package com.coin.info.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.coin.info.entity.Article;
import com.coin.info.mapper.ArticleMapper;
import com.coin.info.service.ArticleService;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements ArticleService {
}
