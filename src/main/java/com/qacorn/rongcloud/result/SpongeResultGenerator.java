package com.qacorn.rongcloud.result;


import com.qacorn.rongcloud.constant.ErrorCode;
import com.qacorn.rongcloud.constant.GlobalConstant;

import java.util.Date;

public class SpongeResultGenerator {

    public static SpongeResult<String> getFromSpongeException(SpongeException exception){
       return new SpongeResult<>(exception.getStatus(),exception.getUserMessage(),new Date(),exception.getUserMessage());
    }

    public static SpongeResult<String> getResult(boolean success){
        return success?getSuccessResult():getErrorResult();
    }

    public static SpongeResult<String> getSuccessResult(){
        return new SpongeResult<>(ErrorCode.NO_ERROR, GlobalConstant.SUCCESS,new Date(), GlobalConstant.SUCCESS);
    }

    public static SpongeResult<String> getSuccessResult(String result){
        return new SpongeResult<>(ErrorCode.NO_ERROR, GlobalConstant.SUCCESS,new Date(), result);
    }

    public static <T> SpongeResult<T> getSuccessEntity(T result){
        return new SpongeResult<>(ErrorCode.NO_ERROR, GlobalConstant.SUCCESS,new Date(), result);
    }

    public static SpongeResult<String> getErrorResult(){
        return new SpongeResult<>(ErrorCode.OPERATE_FAIL, GlobalConstant.ERROR,new Date(), GlobalConstant.ERROR);
    }

    public static SpongeResult<String> getErrorResult(String result){
        return new SpongeResult<>(ErrorCode.OPERATE_FAIL, GlobalConstant.ERROR,new Date(), result);
    }



}
