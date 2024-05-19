package com.hjc.boot.database.mapper;

import com.hjc.boot.database.entity.Article;

import java.util.List;

public interface ArticleMapper {
    void insertArticle(Article article);

    void updateArticle(Article article);

    Article getArticleById(int id);

    List<Article> findAll();

    void deleteArticle(int id);
}
