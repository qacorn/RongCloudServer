package com.qacorn.rongcloud.okhttp;

import com.alibaba.fastjson.JSON;
import com.qacorn.rongcloud.constant.RongCloudCode;
import com.qacorn.rongcloud.constant.RongCloudConstant;
import com.qacorn.rongcloud.info.RongCloudTokenInfo;
import com.qacorn.rongcloud.result.ApiError;
import com.qacorn.rongcloud.result.SpongeException;
import com.qacorn.rongcloud.utility.RandomUtility;
import org.apache.commons.codec.digest.DigestUtils;

import java.util.Random;



public class OkHttpUtils {

    public static GetBuilder get() {
        return new GetBuilder();
    }

    public static PostBuilder post() {
        return new PostBuilder();
    }


//    public static void main(String[] args) {
//        try {
//            System.out.println(getRongCloudToken("123456","yingchen",""));
//        } catch (SpongeException e) {
//            e.printStackTrace();
//        }
//    }

    public static String getRongCloudToken(String userId,String name,String portraitUri) throws SpongeException {

        Random random = new Random();
        String nonce = String.valueOf(random.nextLong());
        String timestamp = String.valueOf(System.currentTimeMillis());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(RongCloudConstant.appSecret).append(nonce).append(timestamp);
        String signature = DigestUtils.sha1Hex(stringBuilder.toString());

        String token = post().url(RongCloudConstant.getTokenUrl)
                .addHeader("App-Key", RongCloudConstant.appKey)
                .addHeader("Nonce",nonce)
                .addHeader("Timestamp",timestamp)
                .addHeader("Signature",signature)

                .addParam("userId",userId)
                .addParam("name",name)
                .addParam("portraitUri",portraitUri)
                .execute();


        RongCloudTokenInfo rongCloudTokenInfo = JSON.parseObject(token, RongCloudTokenInfo.class);
        if (rongCloudTokenInfo.getCode() == RongCloudCode.STATUS_OK) {
            return rongCloudTokenInfo.getToken();
        }else {
            throw new SpongeException(ApiError.GET_RONG_CLOUD_TOKEN_FAIL);
        }


    }
}
