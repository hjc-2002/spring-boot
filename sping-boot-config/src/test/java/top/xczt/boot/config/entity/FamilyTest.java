package top.xczt.boot.config.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;

import static org.junit.jupiter.api.Assertions.*;
@ContextConfiguration
@SpringBootTest
class FamilyTest {
    @Resource
    private Family family;

    @Test
    void testfamily(){
        System.out.println(family);
    }
}