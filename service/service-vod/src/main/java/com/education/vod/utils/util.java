package com.education.vod.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class util implements InitializingBean {
    @Value("${accessKeyId}")
    private String accessKeyId;
    @Value("${accessKeySecret}")
    private String accessKeySecret;

    public  static String AKID;

    public  static String AKS;
    @Override
    public void afterPropertiesSet() throws Exception {
        AKID = accessKeyId;
        AKS = accessKeySecret;
    }
}
