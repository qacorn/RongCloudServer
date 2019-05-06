package com.qacorn.rongcloud.result;

public class SpongeException extends Throwable {

    private Integer status;
    private String userMessage;
    private String debugMessage;
    private Boolean printErrorStack;

    public SpongeException(ApiError apiError){
        this.status = apiError.getStatus();
        this.userMessage = apiError.getUserMessage();
        this.debugMessage = apiError.getDebugMessage();
        this.printErrorStack = apiError.getPrintErrorStack();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getUserMessage() {
        return userMessage;
    }

    public void setUserMessage(String userMessage) {
        this.userMessage = userMessage;
    }

    public String getDebugMessage() {
        return debugMessage;
    }

    public void setDebugMessage(String debugMessage) {
        this.debugMessage = debugMessage;
    }

    public Boolean getPrintErrorStack() {
        return printErrorStack;
    }

    public void setPrintErrorStack(Boolean printErrorStack) {
        this.printErrorStack = printErrorStack;
    }
}
