package com.danyanpi.service.serviceImpl;

import com.danyanpi.bean.User;
import com.danyanpi.dao.UserMapper;
import com.danyanpi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("UserServiceImpl")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getUserByUsername(User user) {
        return userMapper.getUserByUsername(user);
    }

    public int insertUser(User user) {
        return userMapper.insert(user);
    }
}
