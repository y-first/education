package com.education.oss.service.impl;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.education.oss.service.OssService;
import com.education.oss.utils.Constand;
import org.joda.time.DateTime;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.crypto.Data;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@Service
public class OssServiceImpl implements OssService {

    @Override
    public String uploadOssFile(MultipartFile file){
        try {
            // Endpoint以杭州为例，其它Region请按实际情况填写。
            String endpoint = Constand.ACCESS_KEY_POINT;
            // 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，请登录 https://ram.console.aliyun.com 创建。
            String accessKeyId = Constand.ACCESS_KEY_ID;
            String accessKeySecret = Constand.ACCESS_KEY_SECRET;
            String bucketName = Constand.ACCESS_KEY_NAME;
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            // 上传文件流。
            InputStream inputStream = null;
            inputStream = file.getInputStream();
            String string = new DateTime().toString("yyyy/MM/dd");
            String uuid = UUID.randomUUID().toString().replace("-","");
            String originalFilename = file.getOriginalFilename();
            System.out.println(originalFilename);
            originalFilename = uuid+originalFilename;
            ossClient.putObject(bucketName,string+"/"+originalFilename, inputStream);
            // 关闭OSSClient。
            ossClient.shutdown();
            String url = "https://"+bucketName+"."+endpoint+"/"+ string+"/"+originalFilename;
            return url;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
