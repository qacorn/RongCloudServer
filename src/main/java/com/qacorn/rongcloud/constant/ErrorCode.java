package com.qacorn.rongcloud.constant;

public class ErrorCode {


    public static final int NO_ERROR = 0;
    public static final int OPERATE_FAIL = 400_002;
    public static final int INVALID_IDENTITY_CARD_NUMBER = 400_003;
    public static final int HTTP_EXCEPTION = 400_004;
    public static final int NOT_EXIST_USER = 400_005;

    public static final int WRONG_PASSWORD = 400_006;
    public static final int RESOURCE_NOT_FOUND = 400_007;
    public static final int REQUEST_METHOD_NOT_SUPPORTED = 4000_008;
    public static final int TYPE_MISMATCH = 400_019;
    public static final int MISSING_PARAMETER = 400_010;
    public static final int EXIST_USER = 400_011;
    public static final int VERIFY_CODE_ERROR = 400_016;
    public static final int OTHER_ERROR = 400_099;
    public static final int CODE_SEND_TOO_FREQ = 400_100;
    public static final int WRONG_REQUEST = 400_101;


    public static final int BAD_JSON_FORMAT = 900_001;
    public static final int UPLOAD_ERROR_EMPTY_FILE = 900_002;
    public static final int FILE_NOT_EXIST = 900_003;
    public static final int ENCODE_FAIL = 900_004;
    public static final int IO_EXCEPTION = 900_005;
    public static final int SQL_EXCEPTION = 900_006;
    public static final int CIPHER_EXCEPTION = 900_007;
    public static final int INSUFFICIENT_FUND = 900_008;


    public static final int CANNOT_BUY = 400_102;
    public static final int GET_RONG_CLOUD_TOKEN_FAIL = 400_103;
}
