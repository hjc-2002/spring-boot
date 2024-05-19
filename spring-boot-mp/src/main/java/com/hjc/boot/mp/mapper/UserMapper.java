package com.hjc.boot.mp.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hjc.boot.mp.entity.UserDO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
