package com.qacorn.rongcloud.controller;


import com.qacorn.rongcloud.constant.ErrorMessage;
import com.qacorn.rongcloud.constant.GlobalConstant;
import com.qacorn.rongcloud.info.UserInfo;
import com.qacorn.rongcloud.okhttp.OkHttpUtils;
import com.qacorn.rongcloud.result.ApiError;
import com.qacorn.rongcloud.result.SpongeException;
import com.qacorn.rongcloud.result.SpongeResult;
import com.qacorn.rongcloud.result.SpongeResultGenerator;
import com.qacorn.rongcloud.service.impl.UserServiceImpl;
import com.qacorn.rongcloud.utility.LogUtility;
import com.qacorn.rongcloud.utility.ValidateUtility;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;


    @RequestMapping(value = "/register.json", method = {RequestMethod.POST})
    @ApiOperation(value = "用户注册")
    public SpongeResult<UserInfo> registerWithPhone(@RequestParam String userPhone,
                                                           @RequestParam String password
    ) throws SpongeException {
        LogUtility.debug(UserController.class, "phoneNumber:{},password:{},verifyCode:{}", userPhone, password);
        if (userPhone.length() != GlobalConstant.PHONE_NUMBER_LENGTH) {
            throw new SpongeException(ApiError.PHONE_NUMBER_LENGTH_ERROR);
        }
        if (!ValidateUtility.isMobile(userPhone)) {
            throw new SpongeException(ApiError.PHONE_NUMBER_ERROR);
        }
        UserInfo userInfo = userService.getUserInfo(userPhone);
        if (userInfo != null) {
            throw new SpongeException(ApiError.EXIST_USER);
        }

        Long userId = userService.createUser(userPhone, password);
        if (userId > 0) {
            UserInfo userInfoInsert = userService.getUserInfo(userPhone);
            String rongCloudToken = OkHttpUtils.getRongCloudToken(String.valueOf(userId), userInfoInsert.getUserName(), "");
            userInfoInsert.setUserToken(rongCloudToken);
            return SpongeResultGenerator.getSuccessEntity(userInfoInsert);
        }else {
            throw new SpongeException(ApiError.EXIST_USER);
        }
    }


    @RequestMapping(value = "/login.json", method = {RequestMethod.POST})
    @ApiOperation(value = "用户登录")
    public SpongeResult<UserInfo> login(@RequestParam String userPhone,
                                                  @RequestParam String password
    ) throws SpongeException {
        LogUtility.debug(UserController.class, "phoneNumber:{},password:{},verifyCode:{}", userPhone, password);

        UserInfo userInfo = userService.getUserInfo(userPhone);
        if (userInfo == null) {
            throw new SpongeException(ApiError.NOT_EXIST_USER);
        }

        if (!password.equals(userInfo.getPassword())) {
            throw new SpongeException(ApiError.WRONG_PASSWORD);
        }

        String rongCloudToken = OkHttpUtils.getRongCloudToken(userInfo.getUserId(), userInfo.getUserName(), "");
        userInfo.setUserToken(rongCloudToken);
        return SpongeResultGenerator.getSuccessEntity(userInfo);
    }


}
