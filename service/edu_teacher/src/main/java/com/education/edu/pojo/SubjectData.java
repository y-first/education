package com.education.edu.pojo;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class SubjectData {

    @ExcelProperty(index = 0)
    private String onSubjectName;

    @ExcelProperty(index = 1)
    private String twoSubjectName;

}
