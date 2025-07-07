package com.example.articleservice.Projections;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class ArticleProjection {
    private String userName;
    private String title;
    private String content;
}