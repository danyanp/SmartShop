package com.danyanpi.service;

import com.danyanpi.bean.User;

public interface UserService {
    User getUserByUsername(User user);
    int insertUser(User user);
}
