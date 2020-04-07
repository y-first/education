package com.education.edu.controller;

import com.education.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@CrossOrigin
@Api(description = "登陆模块")
public class LoginController {
    @ApiOperation("用户登陆")
    @PostMapping("/user/login")
    public Result<Object> login() {
        Map<String, Object> m = new HashMap<>();
        m.put("token","admin");
        return Result.ok(m);
    }

    @ApiOperation("用户信息获取")
    @GetMapping("/user/info")
    public Result<Object> info() {
        Map<String, Object> m = new HashMap<>();
        m.put("roles","[admin]");
        m.put("name","admin");
        m.put("avater",null);
        return Result.ok(m);
    }
}
