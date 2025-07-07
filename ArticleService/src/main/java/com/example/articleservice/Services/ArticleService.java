package com.example.articleservice.Services;

import com.example.articleservice.Models.Article;
import com.example.articleservice.Projections.ArticleProjection;
import org.springframework.http.ResponseEntity;
import org.antlr.v4.runtime.misc.Pair;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();
    ArticleProjection getArticleById(String Id);
    ArticleProjection createArticle(String author, String title, String content);
    ResponseEntity<Void> deleteArticle(String Id);
    Pair<List<ArticleProjection> , Pair<Boolean , Integer>> getAllArticles(int pageNo , int pageSize);
    ResponseEntity<Void> updateArticle(String Id , String author , String title , String content);
}
