package com.education.edu.controller;


import com.education.edu.pojo.vo.SubjectVo;
import com.education.edu.service.SubjectService;
import com.education.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-04-07
 */
@RestController
@CrossOrigin
@RequestMapping("/edu/subject")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;

    @ApiOperation("excel导入")
    @PostMapping("addSubject")
    public Result<Object> addSubject(MultipartFile file) {
        subjectService.saveSubject(file, subjectService);
        return null;
    }

    @ApiOperation("课程分类查询")
    @GetMapping("cate")
    public Result<List<SubjectVo>> getAllSubject() {
        List<SubjectVo> ls = subjectService.getAllSubject();
        return Result.ok(ls);
    }
}

