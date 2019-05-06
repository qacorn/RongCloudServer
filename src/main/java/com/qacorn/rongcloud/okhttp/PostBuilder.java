package com.qacorn.rongcloud.okhttp;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class PostBuilder extends OkHttpRequestBuilder<PostBuilder> {
    @Override
    protected Call createCall() {
        OkHttpClient okHttpClient = new OkHttpClient();
        Request.Builder request = request();
        RequestBody requestBody = createBody();
        return okHttpClient.newCall(request.post(requestBody).build());
    }
}
