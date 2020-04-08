package com.education.edu.controller;


import com.education.edu.pojo.Video;
import com.education.edu.service.VideoService;
import com.education.utils.Result;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程视频 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-04-08
 */
@RestController
@RequestMapping("/edu/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    @ApiOperation("添加小节")
    @PostMapping("addVideo")
    public Result<Object> addVideo(@RequestBody Video video){
        videoService.save(video);
        return Result.ok(null);
    }

    @ApiOperation("删除小节")
    @DeleteMapping("{id}")
    public Result<Object> delete(@PathVariable("id")String id){
        videoService.removeById(id);
        return Result.ok(null);
    }
}

