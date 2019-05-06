package com.qacorn.rongcloud.result;

import java.util.Date;

public class SpongeResult<T> {

    private Integer status;
    private String message;
    private Date timestamp;
    private T result;

    public SpongeResult() {
    }

    public SpongeResult(Integer status, String message, Date timestamp, T result) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
        this.result = result;
    }

    public SpongeResult(Integer status, String message, T result) {
        this(status, message, new Date(), result);
    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
