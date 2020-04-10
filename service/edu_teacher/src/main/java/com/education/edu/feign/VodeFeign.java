package com.education.edu.feign;

import com.education.feign.OssFeign;
import com.education.utils.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

@FeignClient("service-vod")
public interface VodeFeign extends OssFeign {

}
