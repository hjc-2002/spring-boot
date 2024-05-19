package com.hjc.boot.database.service;

import com.hjc.boot.database.entity.Article;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ArticleJpaServiceTest {

    @Resource
    private ArticleJpaService articleJpaService;

    @Test
    void saveArticle() {
        Article article = Article.builder().author("hjc").title("spring boot").content("Spring Boot").build();
        articleJpaService.saveArticle(article);
    }

    @Test
    void updateArticle() {
        Article article = Article.builder().author("xmq").title("spring boot").content("Spring Boot").id(1).build();
        articleJpaService.updateArticle(article);
    }

    @Test
    void getArticleById() {
        Article article = articleJpaService.getArticleById(1);
        System.out.println(article);
    }

    @Test
    void findAll() {
        List<Article> all = articleJpaService.findAll();
        all.forEach(System.out::println);
    }

    @Test
    void deleteArticle() {
        articleJpaService.deleteArticle(1);
    }
}