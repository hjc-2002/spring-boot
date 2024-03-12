package top.hjc.boot.config.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

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