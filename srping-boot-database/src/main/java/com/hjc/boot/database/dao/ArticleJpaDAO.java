package com.hjc.boot.database.dao;


import com.hjc.boot.database.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticleJpaDAO extends JpaRepository<Article,Integer> {

}
