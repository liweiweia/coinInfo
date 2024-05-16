package com.coin.info.entity;

import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Article {
    private Long id;
    private String title;
    //英文标题
    private String enTitle;
    //法语标题
    private String frTitle;
    private String img;
    private String content;
    //英文内容
    private String enContent;
    //法语内容
    private String frContent;
    private Long authorId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
