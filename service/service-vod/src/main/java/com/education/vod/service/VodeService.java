package com.education.vod.service;

import org.springframework.web.multipart.MultipartFile;

public interface VodeService {
    String uploadAliyun(MultipartFile multipartFile);
}
