package top.xczt.boot.config.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Data
@Component
@Validated
@ConfigurationProperties(prefix = "family")  //整体前缀
@PropertySource(value ={"classpath:family.properties"} ) //加载外部配置文件
public class Family {

    //    @Value("${family.family-name}")
    private String familyName;

    //    @Value("${family.father}")
    private String father;

    //    @Value("${family.mother}")
    private String mother;

    //    @Value("${family.child}")
    private String child;
}