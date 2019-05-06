package com.qacorn.rongcloud.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogUtility {

    public static void trace(Class fileClass, String message, Object... args) {
        Logger logger = LoggerFactory.getLogger(fileClass);
        logger.trace(message, args);
    }

    public static void debug(Class fileClass, String message, Object... args) {
        Logger logger = LoggerFactory.getLogger(fileClass);
        logger.debug(message, args);
    }

    public static void info(Class fileClass, String message, Object... args) {
        Logger logger = LoggerFactory.getLogger(fileClass);
        logger.info(message, args);
    }

    public static void error(Class fileClass, String message, Object... args) {
        Logger logger = LoggerFactory.getLogger(fileClass);
        logger.error(message, args);
    }
}
