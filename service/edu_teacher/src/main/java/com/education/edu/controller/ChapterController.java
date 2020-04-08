package com.education.edu.controller;


import com.education.edu.pojo.Chapter;
import com.education.edu.pojo.vo.ChapterVo;
import com.education.edu.pojo.vo.CourseVo;
import com.education.edu.service.ChapterService;
import com.education.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-04-08
 */
@Api(description = "课程大纲")
@RestController
@CrossOrigin
@RequestMapping("/edu/chapter")
public class ChapterController {

    @Autowired
    private ChapterService chapterService;

    @GetMapping("getChapterVideo/{id}")
    @ApiOperation("查看章节")
    public Result<List<ChapterVo>> getChapterVideo(@PathVariable("id") String id){
        List<ChapterVo> ls  =   chapterService.chapterService(id);
        return Result.ok(ls);
    }

    @ApiOperation("添加章节")
    @PostMapping("addChapter")
    public Result<Object> addChapter(@RequestBody Chapter chapter){
        chapterService.save(chapter);
        return Result.ok(null);
    }

    @ApiOperation("通过章节id查询")
    @GetMapping("getChapterInfo/{chapterId}")
    public Result<Object> getChapterInfo(@PathVariable("chapterId")String id){
        Chapter byId = chapterService.getById(id);
        return Result.ok(byId);
    }
    @ApiOperation("修改章节")
    @PostMapping("updateChapter")
    public Result<Object> updateChapter(@RequestBody Chapter chapter){
        chapterService.updateById(chapter);
        return Result.ok(null);
    }

    @ApiOperation("删除章节")
    @DeleteMapping("{chapterId}")
    public Result<Object> deleteChapter(@PathVariable("chapterId") String chapterId){
        chapterService.deleteChapter(chapterId);
        return Result.ok(null);
    }
}

