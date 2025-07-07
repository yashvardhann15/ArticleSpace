package com.example.articleservice.Advice;

import com.example.articleservice.Exceptions.ArticleCreationException;
import com.example.articleservice.Exceptions.ArticleNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

@org.springframework.web.bind.annotation.ControllerAdvice
public class ControllerAdvice {
    @ExceptionHandler()
    public ResponseEntity<String> handleArticleNotFoundException(ArticleNotFoundException ex) {
        return new ResponseEntity<>("No article found", HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler()
    public ResponseEntity<String> handleArticleCreationException(ArticleCreationException ex) {
        return new ResponseEntity<>("Unable to create article, please try again", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleGenericException(Exception ex) {
        return new ResponseEntity<>("Something went wrong", HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
