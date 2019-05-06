package com.qacorn.rongcloud.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;

import java.text.SimpleDateFormat;

@SpringBootConfiguration
public class ConfigObjectMapper {

    @Autowired
    public void setObjectMapper(ObjectMapper objectMapper) {
        objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
    }

}
