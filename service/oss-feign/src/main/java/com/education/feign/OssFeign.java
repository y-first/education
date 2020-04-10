package com.education.feign;

import com.education.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

public interface OssFeign {
    @PostMapping("uploadAlyiVideo")
    public Result<Object> uploadAliyun(MultipartFile multipartFile);
}
