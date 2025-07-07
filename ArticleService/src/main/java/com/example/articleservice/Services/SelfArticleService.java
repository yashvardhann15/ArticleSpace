package com.example.articleservice.Services;

import com.example.articleservice.Dto.UserServiceDTO;
import com.example.articleservice.Exceptions.ArticleNotFoundException;
import com.example.articleservice.Models.Article;
import com.example.articleservice.Projections.ArticleProjection;
import com.example.articleservice.Repository.ArticleRepository;
import org.springframework.data.domain.Sort;
import org.antlr.v4.runtime.misc.Pair;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.List;

@Service("selfArticleService")
public class SelfArticleService implements ArticleService{

    private ArticleRepository articleRepository;
    private UserService userService;

    public SelfArticleService(ArticleRepository articleRepository, UserService userService){
        this.articleRepository = articleRepository;
        this.userService = userService;
    }

    @Override
    public List<Article> getAllArticles() throws RuntimeException{
        List<Article> articles =  articleRepository.findAll();
        if(!articles.isEmpty()) {
            return articles;
        }
        else throw new ArticleNotFoundException();
    }

    @Override
    public ArticleProjection getArticleById(String id) {
        ArticleProjection article = articleRepository.findArticleById(id);
        if(article == null){
            throw new ArticleNotFoundException();
        }
        return article;
    }

    @Override
    public ArticleProjection createArticle(String userEmail, String title, String content) {
        ResponseEntity<UserServiceDTO> userServiceDto =  userService.getUser(userEmail);
        String userName = userServiceDto.getBody().getName();

        Article article = new Article();
        article.setArticleTitle(title);
        article.setArticleContent(content);
        article.setUserEmail(userEmail);
        article.setUserName(userName);
        articleRepository.save(article);

        ArticleProjection createdArticle = ArticleProjection.builder()
                .userName(userName)
                .title(title)
                .content(content)
                .build();

        return createdArticle;
    }

    @Override
    public ResponseEntity<Void> deleteArticle(String id) {
        if(articleRepository.existsByIdAndIsDeletedFalse(id)){
            Article article = articleRepository.findById(id);
            article.setIsDeleted();
            articleRepository.save(article);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        else throw new ArticleNotFoundException();
    }

    @Override
    public Pair<List<ArticleProjection> , Pair<Boolean , Integer>> getAllArticles(int pageNo , int pageSize) {

        Page<ArticleProjection> pageOfArticles = articleRepository.findAllProjection(PageRequest.of(pageNo, pageSize , Sort.by("createdAt").descending()));
        Boolean hasNext = pageOfArticles.hasNext();
        Integer totalPages = pageOfArticles.getTotalPages();
        return new Pair<>(pageOfArticles.getContent() , new Pair<>(hasNext , totalPages));
    }

    @Override
    public ResponseEntity<Void> updateArticle(String id , String authorEmail , String title , String content){
        if(articleRepository.existsByIdAndIsDeletedFalse(id)){
            Article article = articleRepository.findById(id);
            article.setArticleTitle(title);
            article.setArticleContent(content);
            article.setUpdatedAt(LocalDateTime.now());
            articleRepository.save(article);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        else throw new ArticleNotFoundException();
    }
}
