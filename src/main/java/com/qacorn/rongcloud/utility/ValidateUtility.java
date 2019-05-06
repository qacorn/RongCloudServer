package com.qacorn.rongcloud.utility;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtility {

    private static final Pattern PHONE_PATTERN = Pattern.compile(RegularExpressions.PHONE_NUMBER_REGULAR);
    private static final Pattern VERIFY_CODE_PATTERN = Pattern.compile(RegularExpressions.REGISTER_VERIFY_CODE);


    public static boolean isMobile(final String str) {
        Matcher m = PHONE_PATTERN.matcher(str);
        return m.matches();
    }

    public static boolean isVerifyCode(String verifyCode) {
        Matcher matcher = VERIFY_CODE_PATTERN.matcher(verifyCode);
        return matcher.matches();
    }
}
