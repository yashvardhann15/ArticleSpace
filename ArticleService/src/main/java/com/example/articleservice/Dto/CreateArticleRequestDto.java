package com.example.articleservice.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateArticleRequestDto {
    String authorEmail;
    String articleTitle;
    String articleContent;
}
