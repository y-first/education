package com.education.edu.controller;


import com.education.edu.pojo.vo.CourseVo;
import com.education.edu.service.CourseService;
import com.education.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/edu/course")
@CrossOrigin
public class CourseController {
    @Autowired
    private CourseService courseService;

    @PostMapping("/addCourse")
    public Result<Object> addCourse(@RequestBody CourseVo courseVo) {
        String i  =   courseService.addCourse(courseVo);
        return Result.ok(i);
    }

    @ApiOperation("根据课程id查询课程")
    @GetMapping("getCourseInfo/{id}")
    public Result<CourseVo> getCourseInfo(@PathVariable("id")String id){
        CourseVo cv = courseService.getCourseInfo(id);
        return Result.ok(cv);
    }

    @ApiOperation("修改")
    @PutMapping("updateCourseInfo")
   public Result<Object> updateCourseInfo(@RequestBody CourseVo courseVo)
    {
        courseService.updateCourseInfo(courseVo);
        return Result.ok(null);
    }
}

