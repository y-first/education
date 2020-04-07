package com.education.oss.controller;

import com.education.oss.service.OssService;
import com.education.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/educoss/fileoss")
@Api(description = "OSS对象存储")
public class OssController {

    @Autowired
    private OssService ossService;

    @ApiOperation("上传头像")
    @PostMapping
    public Result<Object> uploadOssFile(MultipartFile file) throws IOException {
        String url = ossService.uploadOssFile(file);
        return Result.ok(url);
    }
}
