package top.xczt.boot.config.entity;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@PropertySource(value ={"classpath:employee.properties"} )
public class Employee {

    //SpEL读取属性，分割成字符串集合
    @Value("#{'${employee.names}'.split(',')}")
    private List<String> employeeNames;

    @Value("#{${employee.ages}}")
    private Map<String,Integer> employeeAges;

    @Value("#{systemProperties['java.home']}")
    private String javaHome;

    @Value("#{systemProperties['user.dir']}")
    private String userDir;
}
