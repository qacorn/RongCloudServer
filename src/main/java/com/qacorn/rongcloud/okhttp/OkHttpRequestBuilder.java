package com.qacorn.rongcloud.okhttp;

import okhttp3.*;
import org.apache.commons.lang3.StringUtils;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public abstract class OkHttpRequestBuilder<T extends OkHttpRequestBuilder> {

    protected String url;
    protected Map<String, String> stringMap;
    protected Map<String, String> headerMap;
    protected Map<String,String> paramMap;

    public T url(String url) {
        this.url = url;
        return (T) this;
    }

    public T addParam(String key, String val) {
        if (this.paramMap == null) {
            paramMap = new LinkedHashMap<>();
        }
        paramMap.put(key, val);
        return (T) this;
    }

    public T addHeader(String key, String val) {
        if (this.headerMap == null) {
            headerMap = new LinkedHashMap<>();
        }
        headerMap.put(key, val);
        return (T) this;
    }

    public T addUrlString(String key, String val) {
        if (this.stringMap == null) {
            stringMap = new LinkedHashMap<>();
        }
        stringMap.put(key, val);
        return (T) this;
    }

    protected Request.Builder request() {
        Request.Builder request = new Request.Builder();
        String str = "";
        if(stringMap!=null) {
            Iterator<Map.Entry<String, String>> iterator = stringMap.entrySet().iterator();
            while (iterator.hasNext()){
                try {
                    Map.Entry<String, String> entry = iterator.next();
                    String key = URLEncoder.encode(entry.getKey(), "utf-8");
                    String value = URLEncoder.encode(entry.getValue(), "utf-8");
                    str += key+"="+value+"&";
                }catch (UnsupportedEncodingException e){
                    e.printStackTrace();
                }
            }
        }
        if (StringUtils.endsWith(str, "&")) {
            str = StringUtils.removeEnd(str, "&");
        }

        if(headerMap!=null){
            Iterator<Map.Entry<String, String>> iterator = headerMap.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String, String> entry = iterator.next();
                request.addHeader(entry.getKey(),entry.getValue());
            }
        }
        return request.url("".equals(str)?url:url+"?"+str);
    }

    protected abstract Call createCall();

    protected RequestBody createBody(){
        RequestBody requestBody ;
        FormBody.Builder formBody = new FormBody.Builder();
        if(paramMap!=null){
            Iterator<Map.Entry<String,String>> iterator = paramMap.entrySet().iterator();
            while (iterator.hasNext()){
                Map.Entry<String,String> entry = iterator.next();
                formBody.add(entry.getKey(),entry.getValue());
            }
        }
        requestBody = formBody.build();
        return requestBody;
    }

    public String execute(){
        Call call = createCall();
        try {
            Response response = call.execute();
            return  response.body().string();
        }catch (IOException e){
            e.getMessage();
        }
        return "";
    }
}
