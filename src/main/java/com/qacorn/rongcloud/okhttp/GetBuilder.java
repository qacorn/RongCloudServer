package com.qacorn.rongcloud.okhttp;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class GetBuilder extends OkHttpRequestBuilder<GetBuilder> {
    @Override
    protected Call createCall() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder request = request();
        return okHttpClient.newCall(request.get().build());
    }
}
