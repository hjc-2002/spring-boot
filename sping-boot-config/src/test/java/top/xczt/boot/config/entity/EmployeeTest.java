package top.xczt.boot.config.entity;

import jakarta.annotation.Resource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.naming.Name;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
public class EmployeeTest {
    @Resource
    private Employee employee;

    @Test
    void testemployee(){
//        List<String> employeeNames=employee.getEmployeeNames();
//        employeeNames.forEach(System.out::println);

//        System.out.println(employee.getEmployeeAges());

//        System.out.println(employee.getJavaHome());

        System.out.println(employee.getUserDir());
    }

}