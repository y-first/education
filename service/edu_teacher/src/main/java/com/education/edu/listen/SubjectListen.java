package com.education.edu.listen;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.education.edu.pojo.Subject;
import com.education.edu.pojo.SubjectData;
import com.education.edu.service.SubjectService;

public class SubjectListen extends AnalysisEventListener<SubjectData> {

    public SubjectService subjectService;

    public SubjectListen(SubjectService subjectService) {
        this.subjectService = subjectService;
    }

    public SubjectListen() {
    }


    @Override
    public void invoke(SubjectData subjectData, AnalysisContext analysisContext) {
        if (subjectData != null) {
            String onSubjectName = subjectData.getOnSubjectName();
            Subject subject = this.existOneSubject(onSubjectName);
            if (subject == null) {
                subject = new Subject();
                subject.setParentId("0");
                subject.setTitle(onSubjectName);
                this.subjectService.save(subject);
            }
            Subject subject1 = this.existTwoSubject(subjectData.getTwoSubjectName(), subject.getParentId());
            if(subject1 == null){
                subject1 = new Subject();
                subject1.setParentId(subject.getId());
                subject1.setTitle(subjectData.getTwoSubjectName());
                this.subjectService.save(subject1);
            }
        }
    }

    private Subject existOneSubject(String name) {
        QueryWrapper<Subject> q = new QueryWrapper<>();
        q.eq("title", name);
        q.eq("parent_id", 0);
        Subject one = this.subjectService.getOne(q);
        return one;
    }

    private Subject existTwoSubject(String name, String pid) {
        QueryWrapper<Subject> q = new QueryWrapper<>();
        q.eq("title", name);
        q.eq("parent_id", pid);
        Subject one = this.subjectService.getOne(q);
        return one;
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
