package top.xczt.boot.quickstart.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import top.xczt.boot.quickstart.controller.ArticleController;
import top.xczt.boot.quickstart.controller.ArticleController;
import top.xczt.boot.quickstart.controller.ArticleController;
import top.xczt.boot.quickstart.pojo.Article;
import top.xczt.boot.quickstart.pojo.Reader;
import top.xczt.boot.quickstart.response.AjaxResponse;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/articles")
public class ArticleController {

    //根据id路径查询文章
    @GetMapping("{id}")
    public AjaxResponse getArticle(@PathVariable("id") Long id){
        List<Reader> readerList=List.of(Reader.builder().name("aaa").age(12).build(),Reader.builder().name("bbb").age(13).build());
        Article article=Article.builder()
                .id(123L)
                .author("xczt")
                .content("SpringBoot 从青铜到王者")
                .title("SpringBoot")
                .readerList(readerList)
                .creteTime(new Date()).build();
        log.info("article:"+article);
        return AjaxResponse.success(article);
    }

    //根据url链接查询文章
    @GetMapping()
    public AjaxResponse getArticleByParam(@RequestParam("id") long id){
        List<Reader> readerList=List.of(Reader.builder().name("aaa").age(12).build(),Reader.builder().name("bbb").age(13).build());
        Article article=Article.builder()
                .id(123L)
                .author("xczt")
                .content("SpringBoot 从青铜到王者")
                .title("SpringBoot")
                .readerList(readerList)
                .creteTime(new Date()).build();
        log.info("article:"+article);
        return AjaxResponse.success(article);
    }

    //查询所有文章
    @GetMapping("all")
    public AjaxResponse selectAll(){
        List<Reader> readerList=List.of(Reader.builder().name("aaa").age(12).build(),Reader.builder().name("bbb").age(13).build());
        Article article=Article.builder()
                .id(111L)
                .author("xczt")
                .content("SpringBoot")
                .title("SpringBoot")
                .readerList(readerList)
                .creteTime(new Date())
                .build();
        Article article2=Article.builder()
                .id(222L)
                .author("xczt")
                .content("Java")
                .title("Java")
                .readerList(readerList)
                .creteTime(new Date())
                .build();
        return AjaxResponse.success(List.of(article,article2));
    }
    //创建一个body文章
    @PostMapping("body")
    public AjaxResponse saveArticleByJsonBody(@RequestBody Article article){
        log.info("saveArticle:"+article);
        return AjaxResponse.success(article);
    }
   //创建一个para文章
    @PostMapping("param")
    public AjaxResponse saveArticleByParams(
            @RequestParam long id ,
            @RequestParam(value = "author", defaultValue = "xczt", required = false) String author ,
            @RequestParam String title ,
            @RequestParam String content ,
            @DateTimeFormat( pattern = "yyy-MM-dd HH:mm:ss")
            @RequestParam Date createTime){
        Article article=Article.builder()
                .id(id)
                .author(author)
                .content(content)
                .title(title)
                .creteTime(createTime)
                .build();
        return AjaxResponse.success(article);
    }
   //创建一个form文章
    @PostMapping("form")
    public AjaxResponse saveArticleByFormData(@RequestParam("formData") String formData){
        log.info("formData:"+formData);
        //Jackson反序列化将字符串转换为Java对象
        ObjectMapper mapper=new ObjectMapper();
        Article article=null;
        try {
            article =mapper.readValue(formData,Article.class);
            log.info("article"+article);
        }catch (JsonProcessingException e){
            e.printStackTrace();
        }
        return AjaxResponse.success(article);
    }
   //根据id修改文章
    @PutMapping()
    public AjaxResponse updateArticle(@RequestBody Article article){
        if(article.getId()==null){
            log.error("没有id");
        }
        log.info("updateArticle:"+article);
        return AjaxResponse.success(article);
    }
//     根据id删除文章
    @DeleteMapping("{id}")
    public AjaxResponse deleteArticle(@PathVariable("id") Long id){
        log.info("deleteArticle:"+id);
        return AjaxResponse.success();
    }
}
