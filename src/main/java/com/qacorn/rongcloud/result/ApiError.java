package com.qacorn.rongcloud.result;


import com.qacorn.rongcloud.constant.ErrorCode;
import com.qacorn.rongcloud.constant.ErrorMessage;

public enum ApiError {

    NOT_EXIST_USER(ErrorCode.NOT_EXIST_USER, ErrorMessage.not_exist_user,"not_exist_user",false),
    EXIST_USER(ErrorCode.EXIST_USER, ErrorMessage.exist_user,"exist_user",false),
    REGISTER_FAIL(ErrorCode.REGISTER_FAIL, ErrorMessage.REGISTER_FAIL,"REGISTER_FAIL",false),
    WRONG_PASSWORD(ErrorCode.WRONG_PASSWORD, ErrorMessage.wrong_password,"wrong password",false),
    PHONE_NUMBER_LENGTH_ERROR(ErrorCode.PHONE_NUMBER_LENGTH_ERROR, ErrorMessage.PHONE_NUMBER_LENGTH_ERROR,"PHONE_NUMBER_LENGTH_ERROR",false),
    PHONE_NUMBER_ERROR(ErrorCode.PHONE_NUMBER_ERROR, ErrorMessage.PHONE_NUMBER_ERROR,"PHONE_NUMBER_ERROR",false),
    VERIFY_CODE_ERROR(ErrorCode.VERIFY_CODE_ERROR,ErrorMessage.REGISTER_VERIFY_CODE_ERROR,"verify_code_error",false),
    INVALID_IDENTITY_CARD_NUMBER(ErrorCode.INVALID_IDENTITY_CARD_NUMBER, ErrorMessage.invalid_identity_card_number,"invalid_identity_card_number",false),
    HTTP_EXCEPTION(ErrorCode.HTTP_EXCEPTION, ErrorMessage.http_exception,"http_exception",true),
    BAD_JSON_FORMAT(ErrorCode.BAD_JSON_FORMAT, ErrorMessage.bad_json_format,"bad_json_format",true),
    UPLOAD_ERROR_EMPTY_FILE(ErrorCode.UPLOAD_ERROR_EMPTY_FILE, ErrorMessage.upload_error_empty_file,"upload_error_empty_file",true),
    FILE_NOT_EXIST(ErrorCode.FILE_NOT_EXIST, ErrorMessage.file_not_exist,"file_not_exist",true),
    ENCODE_FAIL(ErrorCode.ENCODE_FAIL, ErrorMessage.encode_fail,"encode_fail",true),
    IO_EXCEPTION(ErrorCode.IO_EXCEPTION, ErrorMessage.io_exception,"io_exception",true),
    UNKNOWN_ERROR(ErrorCode.OTHER_ERROR, ErrorMessage.other_error,"other_error",true),
    SQL_EXCEPTION(ErrorCode.SQL_EXCEPTION, ErrorMessage.sql_exception,"sql_exception",true),
    CIPHER_EXCEPTION(ErrorCode.CIPHER_EXCEPTION, ErrorMessage.cipher_exception,"cipher_exception",true),
    INSUFFICIENT_FUND(ErrorCode.INSUFFICIENT_FUND, ErrorMessage.insufficient_fund,"insufficient_fund",true),
    CODE_SEND_TOO_FREQ(ErrorCode.CODE_SEND_TOO_FREQ, ErrorMessage.code_send_too_freq,"code_send_too_freq",false),
    WRONG_REQUEST(ErrorCode.WRONG_REQUEST, ErrorMessage.wrong_request,"wrong_request",false),
    CANNOT_BUY(ErrorCode.CANNOT_BUY, ErrorMessage.cannot_buy,"cannot_buy",false),
    GET_RONG_CLOUD_TOKEN_FAIL(ErrorCode.GET_RONG_CLOUD_TOKEN_FAIL,ErrorMessage.get_rong_cloud_token_fail,"get_rong_cloud_token_fail",false);


    private Integer status;
    private String  userMessage;
    private String debugMessage;
    private Boolean printErrorStack;


    ApiError(Integer status, String userMessage, String debugMessage, Boolean printErrorStack) {
        this.status = status;
        this.userMessage = userMessage;
        this.debugMessage = debugMessage;
        this.printErrorStack = printErrorStack;
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
