package com.ck.demo.service;

import com.ck.demo.mapper.UserMapper;
import com.ck.demo.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
     private UserMapper userMapper;
    public User userService(String s){
       return userMapper.findByName(s);
    }
}
