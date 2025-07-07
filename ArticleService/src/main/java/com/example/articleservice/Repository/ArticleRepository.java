package com.example.articleservice.Repository;
import com.example.articleservice.Models.Article;
import com.example.articleservice.Projections.ArticleProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ArticleRepository extends MongoRepository<Article, Long> {
    ArticleProjection findArticleById(String Id);
    Article findById(String Id);
    Article  save(Article article);
    List<Article> findAll();
    boolean existsByIdAndIsDeletedFalse(String Id);
    @Query(value = "{ 'isDeleted' : false }", fields = "{ 'id' : 1, 'title' : 1, 'content' : 1, 'createdAt' : 1, 'author.name' : 1 }")
    Page<ArticleProjection> findAllProjection(Pageable pageable);
}
