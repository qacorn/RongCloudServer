package com.qacorn.rongcloud.dao;

import com.qacorn.rongcloud.info.UserInfo;

public interface UserDao {


    Long insertUser(String userPhone, String password);

    UserInfo getUserInfo(String userPhone);

}
