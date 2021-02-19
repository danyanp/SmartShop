package com.danyanpi.dao;

import com.danyanpi.bean.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {

    //获取全部的用户
    @Select("select * from smartshop.user")
    List<User> getAllUsers();

    @Select("select * from smartshop.user where username = (#{username})")
    User getUserByUsername(User user);

    @Insert("insert smartshop.user(username,password,role) VALUES (#{username},#{password},#{role})")
    int insert(User user);
}
