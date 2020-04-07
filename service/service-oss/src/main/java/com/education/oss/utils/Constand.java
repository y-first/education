package com.education.oss.utils;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.xml.crypto.dsig.keyinfo.KeyName;

@Component
public class Constand implements InitializingBean {
    @Value("${aliyun.oss.file.endpoint}")
    private String endpoint;
    @Value("${aliyun.oss.file.keyid}")
    private String keyid;
    @Value("${aliyun.oss.file.keysecret}")
    private String keysecret;
    @Value("${aliyun.oss.file.bucketname}")
    private String bucketname;

    public static String ACCESS_KEY_ID;
    public static String ACCESS_KEY_SECRET;
    public static String ACCESS_KEY_NAME;
    public static String ACCESS_KEY_POINT;

    @Override
    public void afterPropertiesSet() throws Exception {
        ACCESS_KEY_ID=keyid;
        ACCESS_KEY_SECRET=keysecret;
        ACCESS_KEY_NAME= bucketname;
        ACCESS_KEY_POINT=endpoint;
    }
}
