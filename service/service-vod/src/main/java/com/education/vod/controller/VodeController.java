package com.education.vod.controller;

import com.education.vod.service.VodeService;
import com.education.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/eduvod/video")
@CrossOrigin
public class VodeController {

    @Autowired
    private VodeService vodeService;

    @PostMapping("uploadAlyiVideo")
    public Result<Object> uploadAliyun(MultipartFile multipartFile) {
        System.out.println(multipartFile);
        String id = vodeService.uploadAliyun(multipartFile);
        System.out.println(id);
        return Result.ok(id);
    }
}
