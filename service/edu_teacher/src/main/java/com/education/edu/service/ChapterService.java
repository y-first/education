package com.education.edu.service;

import com.education.edu.pojo.Chapter;
import com.baomidou.mybatisplus.extension.service.IService;
import com.education.edu.pojo.vo.ChapterVo;
import com.education.edu.pojo.vo.CourseVo;

import java.util.List;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author testjava
 * @since 2020-04-08
 */
public interface ChapterService extends IService<Chapter> {

    List<ChapterVo> chapterService(String id);

    void deleteChapter(String chapterId);
}
