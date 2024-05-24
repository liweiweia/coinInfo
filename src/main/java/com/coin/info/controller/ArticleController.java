package com.coin.info.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.coin.info.entity.Article;
import com.coin.info.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/api/articles")
public class ArticleController {
    @Autowired
    private ArticleService articleService;

    @PostMapping
    public Article createArticle(@RequestBody Article article) {
        articleService.save(article);
        return article;
    }

    @GetMapping("/{id}")
    public Article getArticleById(@PathVariable Long id) {
        return articleService.getById(id);
    }

    @GetMapping
    public List<Article> getAllArticles() {
        return articleService.list();
    }

    @PutMapping("/{id}")
    public Article updateArticle(@PathVariable Long id, @RequestBody Article article) {
        article.setId(id);
        articleService.updateById(article);
        return article;
    }

    @DeleteMapping("/{id}")
    public void deleteArticle(@PathVariable Long id) {
        articleService.removeById(id);
    }

    @GetMapping("/page")
    public IPage<Article> getArticlesByPage(
            @RequestParam(name = "page", defaultValue = "1") int page,
            @RequestParam(name = "size", defaultValue = "10") int size) {
        Page<Article> articlePage = new Page<>(page, size);
        // 添加按创建时间倒序排序条件
        articlePage.setOrders(Arrays.asList(OrderItem.desc("created_at")));
        return articleService.page(articlePage);
    }
}
