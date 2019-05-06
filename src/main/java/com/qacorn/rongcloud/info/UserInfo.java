package com.qacorn.rongcloud.info;

import com.qacorn.rongcloud.domain.RongUser;

public class UserInfo {

    private String userId;
    private String userPhone;
    private String userName;
    private Byte userStatus;
    private Long createTime;

    public static UserInfo build(RongUser rongUser) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(rongUser.getUserId());
        userInfo.setUserPhone(rongUser.getUserPhone());
        userInfo.setUserName(rongUser.getUserName());
        userInfo.setUserStatus(rongUser.getUserStatus());
        userInfo.setCreateTime(rongUser.getCreateTime().getTime());
        return userInfo;
    }


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Byte getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Byte userStatus) {
        this.userStatus = userStatus;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
