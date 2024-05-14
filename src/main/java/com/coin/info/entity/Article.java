package com.coin.info.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Article {
    private Long id;
    private String title;
    private String img;
    private String content;
    private Long authorId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
