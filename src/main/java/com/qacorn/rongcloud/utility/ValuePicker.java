package com.qacorn.rongcloud.utility;

public interface ValuePicker<S, T> {
    T pickValue(S source);
}