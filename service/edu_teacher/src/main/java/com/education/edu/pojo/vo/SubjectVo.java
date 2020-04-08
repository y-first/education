package com.education.edu.pojo.vo;

import com.education.edu.pojo.Subject;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SubjectVo {
    private String id;
    private String title;
    private List<TwoSubject> data = new ArrayList<>();
}
