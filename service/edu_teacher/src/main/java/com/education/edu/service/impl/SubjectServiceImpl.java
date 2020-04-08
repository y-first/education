package com.education.edu.service.impl;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.education.edu.listen.SubjectListen;
import com.education.edu.pojo.Subject;
import com.education.edu.mapper.SubjectMapper;
import com.education.edu.pojo.SubjectData;
import com.education.edu.pojo.vo.SubjectVo;
import com.education.edu.pojo.vo.TwoSubject;
import com.education.edu.service.SubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-04-07
 */
@Service
public class SubjectServiceImpl extends ServiceImpl<SubjectMapper, Subject> implements SubjectService {

    @Autowired
    private SubjectMapper subjectMapper;

    @Override
    public void saveSubject(MultipartFile file,SubjectService subjectService) {
        try {
            InputStream inputStream = file.getInputStream();
            EasyExcel.read(inputStream, SubjectData.class,new SubjectListen(subjectService)).sheet().doRead();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<SubjectVo> getAllSubject() {
        List<SubjectVo> ls = new ArrayList<>();
        List<Subject> first = subjectMapper.selectList(new QueryWrapper<Subject>().eq("parent_id", "0"));
        List<Subject> two = subjectMapper.selectList(new QueryWrapper<Subject>().ne("parent_id", "0"));
        first.forEach(date ->{
            SubjectVo sub =  new SubjectVo();
            BeanUtils.copyProperties(date,sub);
            List<TwoSubject> l = new ArrayList<>();
            two.forEach(d->{
                TwoSubject t = new TwoSubject();
                BeanUtils.copyProperties(d,t);
                if(d.getParentId().equals(sub.getId())){
                    l.add(t);
                }
            });
            sub.setData(l);
            ls.add(sub);
        });
        return ls;
    }
}
