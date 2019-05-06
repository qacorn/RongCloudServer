package com.qacorn.rongcloud.result;



import com.qacorn.rongcloud.constant.ErrorCode;
import com.qacorn.rongcloud.constant.GlobalConstant;

import java.util.Date;
import java.util.List;

public class SpongeResultList<T> extends SpongeResult<ResultList<T>> {

    public SpongeResultList() {
    }

    public SpongeResultList(Integer status, String message, Date timestamp, ResultList<T> data) {
        super(status, message, timestamp, data);
    }

    public SpongeResultList(List<T> resultList, Integer currentPage, Integer pageSize){
        this(ErrorCode.NO_ERROR, GlobalConstant.SUCCESS,new Date(),new ResultList<>(resultList,currentPage,pageSize));
    }
}
