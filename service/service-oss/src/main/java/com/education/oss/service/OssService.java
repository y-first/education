package com.education.oss.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;

public interface OssService {

    String uploadOssFile(MultipartFile file) throws IOException;
}
