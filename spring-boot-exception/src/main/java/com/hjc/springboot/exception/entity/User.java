package com.hjc.springboot.exception.entity;


import com.hjc.springboot.exception.annotation.IDCard;
import com.hjc.springboot.exception.annotation.Phone;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class User {

    @NotBlank(message = "用户名不能为空")
    private String username;

    @NotBlank(message ="密码不能为空")
    private String password;

    @Max(value = 100,message = "年龄不能大于100")
    @Min(value = 10,message = "年龄不能小于10")
    private Integer age;

    @Phone
    private String phone;


    @IDCard
    private String idCard;
}
