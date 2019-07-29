package com.ck.demo.mapper;

import com.ck.demo.pojo.User;


public interface UserMapper {
    User findByName(String name);
}
