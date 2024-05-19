package com.hjc.springboot.exception.service;


import com.hjc.springboot.exception.exception.ServerException;
import com.hjc.springboot.exception.enums.ErrorCode;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    public void unAuthorizedError(){
        throw new ServerException(ErrorCode.UNAUTHORIZED);
    }

    /*
    * 模拟系统异常
    * */
    public void serverError() {
        throw new ServerException(ErrorCode.INTERNAL_SERVER_ERROR);
    }
}
