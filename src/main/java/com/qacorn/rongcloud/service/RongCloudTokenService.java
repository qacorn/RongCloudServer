package com.qacorn.rongcloud.service;

import com.qacorn.rongcloud.info.RongCloudTokenInfo;

public interface RongCloudTokenService {

    RongCloudTokenInfo getRongCloudToken(String userId, String name, String portraitUri);
}
