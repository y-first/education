package com.education.vod.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import com.education.vod.service.VodeService;
import com.education.vod.utils.util;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

@Service
public class VodeServiceImpl implements VodeService {
    @Override
    public String uploadAliyun(MultipartFile multipartFile) {
        String vedoId = null;
        try {
            UploadStreamRequest request = new UploadStreamRequest(util.AKID, util.AKS, multipartFile.getOriginalFilename(), multipartFile.getOriginalFilename(), multipartFile.getInputStream());
            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);
            if (response.isSuccess()) {
                vedoId =response.getVideoId();
            } else { //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
                System.out.print("VideoId=" + response.getVideoId() + "\n");
                System.out.print("ErrorCode=" + response.getCode() + "\n");
                System.out.print("ErrorMessage=" + response.getMessage() + "\n");
            }
        }catch (Exception e){

        }

        return vedoId;
    }
}
