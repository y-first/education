package com.education.edu.service;

import com.education.edu.pojo.Subject;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.edu.pojo.vo.SubjectVo;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * <p>
 * 课程科目 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-04-07
 */
public interface SubjectService extends IService<Subject> {

    void saveSubject(MultipartFile file,SubjectService subjectService);

    List<SubjectVo> getAllSubject();
}
