package com.hjc.boot.database.dao;


import com.hjc.boot.database.entity.Article;
import jakarta.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository // 数据持久层
public class ArticleJDBCDAO {
    @Resource
    private JdbcTemplate jdbcTemplate;

    /*
    * 新增文章
    * @param article 文章对象
    * */
    public int save(Article article){
        String sql = "INSERT INTO t_article(author,title,content) values(?,?,?)";
        return jdbcTemplate.update(sql,article.getAuthor(),article.getTitle(),article.getContent());
    }

    /*
    * 更新文章
    * */
    public int updateById(Article article){
        return jdbcTemplate.update("update t_article set author = ?,title = ?,content = ? where id=?",article.getAuthor(),article.getTitle(),article.getContent(),article.getId());
    }

    /*
    * 根据id查找文章
    * */
    public Article findById(Long id){
        // queryForObject 用于查询
        return jdbcTemplate.queryForObject("select * from t_article where id = ?",new Object[]{id},new BeanPropertyRowMapper<>(Article.class));
    }

    /*
    * 查询所有文章
    * */
    public List<Article> findAll(){
        return jdbcTemplate.query("select * from t_article",new BeanPropertyRowMapper<>(Article.class));
    }

    /*
    * 根据id 删除文章
    * */
    public int deleteById(Long id){
        return jdbcTemplate.update("DELETE from t_article where id = ?",id);
    }
}
