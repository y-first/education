package com.education.edu.config;

import com.education.utils.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Result<Object> error(Exception e){
        e.printStackTrace();
        return  Result.fail(e.getMessage());
    }
}
