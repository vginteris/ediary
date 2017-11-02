package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import school.model.SchoolSubject;
import school.service.SubjectService;
import school.service.TeacherService;

import java.util.List;

@Controller
public class SubjectController {
    @Autowired
    SubjectService subjectService;
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/allsubjects", method = RequestMethod.GET)
    public ModelAndView getAllSubjects(){
        ModelAndView model = new ModelAndView("administrator/subject");
        List<SchoolSubject> subjectList = subjectService.getAllSubject();
        model.addObject("subjectList",subjectList);
        return model;
    }
}
