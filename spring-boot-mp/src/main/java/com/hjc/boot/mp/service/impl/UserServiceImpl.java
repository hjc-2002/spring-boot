package com.hjc.boot.mp.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hjc.boot.mp.entity.UserDO;
import com.hjc.boot.mp.mapper.UserMapper;
import com.hjc.boot.mp.service.UserService;
import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, UserDO> implements UserService {

}
