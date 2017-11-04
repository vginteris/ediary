package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    @RequestMapping(value = "/removesubject",method = RequestMethod.DELETE)
    public String deleteSubject(@RequestParam(value = "subjectid") long subjectid){
        subjectService.deleteSubjectById(subjectid);
        return "redirect:/allsubjects";
    }
    @RequestMapping(value = "/addsubject", method = RequestMethod.POST)
    public String addNewSubject(@ModelAttribute SchoolSubject subject){
        subjectService.addNewSubject(subject);
        return "redirect:/allsubjects";
    }
    @RequestMapping(value = "/updatesubject", method = RequestMethod.POST)
    public String updateSubjectNameAndType(@ModelAttribute SchoolSubject schoolSubject){
        subjectService.updateSubjectNameAndType(schoolSubject.getSubjectName(),schoolSubject.getSubjectType(),schoolSubject.getSubjectid());
        return "redirect:/allsubjects";
    }
}
