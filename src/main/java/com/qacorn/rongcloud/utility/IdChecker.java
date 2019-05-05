package com.qacorn.rongcloud.utility;

public interface IdChecker<T> {
    Boolean tryId(Long id, T argument);
}
