package com.ck.demo.mapper;

import com.ck.demo.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    User findByName(String name);
}
