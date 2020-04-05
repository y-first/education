package com.education.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.education.edu.pojo.Teacher;
import com.education.edu.mapper.TeacherMapper;
import com.education.edu.pojo.vo.TeacherVo;
import com.education.edu.service.TeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.utils.Condition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-04-04
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {

    @Autowired
    TeacherMapper teacherMapper;

    @Override
    public List<Teacher> findAllTeacher() {
        return  teacherMapper.selectList(new QueryWrapper<Teacher>());
    }

    @Override
    public IPage<Teacher> pageTeacherCon(Condition condition, TeacherVo tv) {
        Page<Teacher> page = new Page<>(condition.getCurrent(), condition.getSize());
        QueryWrapper<Teacher> q = new QueryWrapper<>();
        if (!StringUtils.isEmpty(tv.getName())) {
            q.like("name", tv.getName());
        } else if (!StringUtils.isEmpty(tv.getLevel())) {
            q.like("level", tv.getLevel());
        } else if (!StringUtils.isEmpty(tv.getBegin())) {
            q.ge("gmt_create", tv.getBegin())
            ;
        } else if (!StringUtils.isEmpty(tv.getEnd())) {
            q.le("gmt_create", tv.getEnd());
        }
        IPage<Teacher> page1 = this.page(page, q);
        return page1;
    }

}
