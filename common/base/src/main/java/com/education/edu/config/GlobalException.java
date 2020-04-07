package com.education.edu.config;

import com.education.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
public class GlobalException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Object> error(Exception e){
        log.error(e.getMessage());
        e.printStackTrace();
        return  Result.fail(e.getMessage());
    }
}
