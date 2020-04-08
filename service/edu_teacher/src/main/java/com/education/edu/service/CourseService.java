package com.education.edu.service;

import com.education.edu.pojo.Course;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.edu.pojo.vo.CourseVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-04-08
 */
public interface CourseService extends IService<Course> {


    String addCourse(CourseVo courseVo);

    CourseVo getCourseInfo(String id);

    void updateCourseInfo(CourseVo courseVo);
}
