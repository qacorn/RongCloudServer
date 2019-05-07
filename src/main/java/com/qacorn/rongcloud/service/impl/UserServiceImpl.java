package com.qacorn.rongcloud.service.impl;

import com.qacorn.rongcloud.dao.impl.UserDaoImpl;
import com.qacorn.rongcloud.info.UserInfo;
import com.qacorn.rongcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDaoImpl userDao;

    @Override
    public Long createUser(String userPhone, String password) {
        Long userId = userDao.insertUser(userPhone, password);
        return userId;
    }

    @Override
    public UserInfo getUserInfo(String userPhone) {
        UserInfo userInfo = userDao.getUserInfo(userPhone);
        return userInfo;
    }
}
