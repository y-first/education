package com.education.edu.service.impl;

import com.education.edu.mapper.CourseDescriptionMapper;
import com.education.edu.pojo.Course;
import com.education.edu.mapper.CourseMapper;
import com.education.edu.pojo.CourseDescription;
import com.education.edu.pojo.vo.CourseVo;
import com.education.edu.service.CourseService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-04-08
 */
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {

    @Autowired
    private CourseMapper courseMapper;

    @Autowired
    private CourseDescriptionMapper descriptionMapper;

    @Override
    public String addCourse(CourseVo courseVo) {
        courseMapper.insert(courseVo);
        CourseDescription cd = new CourseDescription();
        cd.setId(courseVo.getId());
        cd.setDescription(courseVo.getDescription());
        descriptionMapper.insert(cd);
        return courseVo.getId();
    }

    @Override
    public CourseVo getCourseInfo(String id) {
        Course course = courseMapper.selectById(id);
        CourseDescription courseDescription = descriptionMapper.selectById(id);
        CourseVo cv = new CourseVo();
        BeanUtils.copyProperties(course,cv);
        cv.setDescription(courseDescription.getDescription());
        return cv;
    }

    @Override
    public void updateCourseInfo(CourseVo courseVo) {
        Course cv = new Course();
        BeanUtils.copyProperties(courseVo,cv);
        courseMapper.updateById(cv);
        CourseDescription cd = new CourseDescription();
        BeanUtils.copyProperties(courseVo,cd);
        descriptionMapper.updateById(cd);
    }
}
