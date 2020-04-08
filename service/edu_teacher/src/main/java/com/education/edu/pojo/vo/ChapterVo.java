package com.education.edu.pojo.vo;

import com.education.edu.pojo.Chapter;
import com.education.edu.pojo.Video;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ChapterVo extends Chapter {
    List<Video> children = new ArrayList<>();
}
