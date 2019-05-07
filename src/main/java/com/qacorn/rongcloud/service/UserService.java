package com.qacorn.rongcloud.service;

import com.qacorn.rongcloud.info.UserInfo;

public interface UserService {

    Long createUser(String userPhone, String password);

    UserInfo getUserInfo(String userPhone);
}
