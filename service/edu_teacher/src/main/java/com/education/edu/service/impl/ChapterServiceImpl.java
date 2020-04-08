package com.education.edu.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.education.edu.mapper.VideoMapper;
import com.education.edu.pojo.Chapter;
import com.education.edu.mapper.ChapterMapper;
import com.education.edu.pojo.Video;
import com.education.edu.pojo.vo.ChapterVo;
import com.education.edu.service.ChapterService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.education.edu.service.VideoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author testjava
 * @since 2020-04-08
 */
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {

    @Autowired
    private ChapterMapper chapterMapper;

    @Autowired
    private VideoMapper videoMapper;

    @Autowired
    private VideoService videoService;

    @Override
    public List<ChapterVo> chapterService(String id) {
        List<ChapterVo> chapterVos = new ArrayList<>();
        List<Chapter> course_id = chapterMapper.selectList(new QueryWrapper<Chapter>().eq("course_id", id));
        List<Video> Video = videoMapper.selectList(new QueryWrapper<Video>().eq("course_id", id));
        course_id.forEach(course->{
            ChapterVo cv = new ChapterVo();
            BeanUtils.copyProperties(course,cv);
            List<Video> v = new ArrayList<>();
            Video.forEach(video -> {
                if(video.getChapterId().equals(course.getId()))
                {
                    v.add(video);
                }
            });
            cv.setChildren(v);
            chapterVos.add(cv);
        });
        return chapterVos;
    }

    @Override
    public void deleteChapter(String chapterId) {
        QueryWrapper<Video> q = new QueryWrapper<>();
        q.eq("chapter_id",chapterId);
        int count = videoService.count(q);
        System.out.println(count);
        if(count>0){

       }else{
           chapterMapper.deleteById(chapterId);
       }
    }
}
