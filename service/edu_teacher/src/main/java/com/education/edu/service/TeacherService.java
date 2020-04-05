package com.education.edu.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.education.edu.pojo.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.edu.pojo.vo.TeacherVo;
import com.education.utils.Condition;

import java.util.List;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-04-04
 */
public interface TeacherService extends IService<Teacher> {

    List<Teacher> findAllTeacher();

    IPage<Teacher> pageTeacherCon(Condition condition, TeacherVo tv);
}
