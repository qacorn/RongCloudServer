package com.qacorn.rongcloud.dao.impl;

import com.qacorn.rongcloud.constant.GlobalConstant;
import com.qacorn.rongcloud.dao.UserDao;
import com.qacorn.rongcloud.domain.RongUser;
import com.qacorn.rongcloud.mapper.RongUserMapper;
import com.qacorn.rongcloud.utility.RandomUtility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private RongUserMapper rongUserMapper;

    @Override
    public Long insertUser(String userPhone, String userName) {
        RongUser rongUser = new RongUser();
        return RandomUtility.generateRandomId(GlobalConstant.USER_ID_LENGTH,rongUser,(id,argument)->{
            argument.setUserId(String.valueOf(id));
            argument.setUserPhone(userPhone);
            argument.setUserName(userName);
            return 1 == rongUserMapper.insertSelective(argument);
        });
    }
}
