package com.qacorn.rongcloud.dao.impl;

import com.qacorn.rongcloud.constant.GlobalConstant;
import com.qacorn.rongcloud.dao.UserDao;
import com.qacorn.rongcloud.domain.RongUser;
import com.qacorn.rongcloud.domain.RongUserExample;
import com.qacorn.rongcloud.info.UserInfo;
import com.qacorn.rongcloud.mapper.RongUserMapper;
import com.qacorn.rongcloud.utility.ListUtility;
import com.qacorn.rongcloud.utility.RandomUtility;
import org.mybatis.generator.codegen.mybatis3.ListUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private RongUserMapper rongUserMapper;

    @Override
    public Long insertUser(String userPhone, String password) {
        RongUser rongUser = new RongUser();
        return RandomUtility.generateRandomId(GlobalConstant.USER_ID_LENGTH,rongUser,(id,argument)->{
            argument.setUserId(String.valueOf(id));
            argument.setUserPhone(userPhone);
            argument.setUserPassword(password);
            argument.setUserName(userPhone);
            return 1 == rongUserMapper.insertSelective(argument);
        });
    }

    @Override
    public UserInfo getUserInfo(String userPhone) {
        RongUserExample rongUserExample =new RongUserExample();
        RongUserExample.Criteria criteria =rongUserExample.createCriteria();
        criteria.andUserPhoneEqualTo(userPhone);
        List<RongUser> rongUserList = rongUserMapper.selectByExample(rongUserExample);
        return ListUtility.orFirst(rongUserList,UserInfo::build);
    }
}
