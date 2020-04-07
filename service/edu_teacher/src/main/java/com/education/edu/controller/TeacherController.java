package com.education.edu.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.education.edu.pojo.Teacher;
import com.education.edu.pojo.vo.TeacherVo;
import com.education.edu.service.TeacherService;
import com.education.utils.Condition;
import com.education.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.ibatis.jdbc.Null;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author testjava
 * @since 2020-04-04
 */
@Api(description = "讲师管理")
@RestController
@CrossOrigin
@RequestMapping("/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;




    /**
     * 查询讲师表所有数据
     */
    @ApiOperation("查询讲师列表")
    @GetMapping("findAll")
    public Result<List<Teacher>> findAllTeacher() {
        List<Teacher> ls = teacherService.findAllTeacher();
        return Result.ok(ls);
    }

    /**
     * 讲师逻辑删除
     */
    @ApiOperation("讲师逻辑删除")
    @DeleteMapping("delete/{id}")
    public Result<Null> deleteTeacher(@PathVariable("id") String id) {
        boolean b = teacherService.removeById(id);
        if (b) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation("讲师分页")
    @GetMapping("pageTeacher")
    public Result<Object> pageTeacher(Condition condition) {
        Page<Teacher> page = new Page<>(condition.getCurrent(), condition.getSize());
        Map<String, Object> m = new HashMap<>();
        IPage<Teacher> page1 = teacherService.page(page, new QueryWrapper<Teacher>().orderByDesc("gmt_create"));
        m.put("total", page1.getTotal());
        m.put("rows", page1.getRecords());
        return Result.ok(m);
    }


    @ApiOperation("添加讲师")
    @PostMapping("/addTeacher")
    public Result<Object> addTeacher(@RequestBody Teacher teacher) {
        boolean save = teacherService.save(teacher);
        if (save) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

    @ApiOperation("条件分页查询讲师")
    @GetMapping("pageTeacherCon/{current}/{size}")
    public Result<Object> pageTeacherCon
            (@PathVariable("current")String current,@PathVariable("size")String size, TeacherVo tv) {

        Condition condition = new Condition( Integer.valueOf(current), Integer.valueOf(size));
        IPage<Teacher> page1 = teacherService.pageTeacherCon(condition, tv);
        Map<String, Object> m = new HashMap<>();
        m.put("total", page1.getTotal());
        m.put("rows", page1.getRecords());
        return Result.ok(m);
    }


    @ApiOperation("通过id查询讲师")
    @GetMapping("getTeacher/{id}")
    public Result<Object> updateTeacher(@PathVariable("id") String id) {
        return Result.ok(teacherService.getById(id));
    }

    @ApiOperation("讲师修改")
    @PostMapping("updateTeacher")
    public Result<Object> updateTeacher(@RequestBody Teacher teacher) {
        boolean b = teacherService.updateById(teacher);
        if (b) {
            return Result.ok(null);
        } else {
            return Result.fail(null);
        }
    }

}

