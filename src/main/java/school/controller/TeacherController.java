package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import school.model.Teacher;
import school.service.TeacherService;

import java.util.List;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public ModelAndView getAllTeacher(){
        ModelAndView model = new ModelAndView("administrator/teacher");
        List<Teacher> teacherList = teacherService.getAllTeacher();
        return model.addObject("teacherList", teacherList);
    }
    @RequestMapping(value = "/newapteacher",method = RequestMethod.POST)
    public String addNewTeacher(@ModelAttribute Teacher teacher){
        teacherService.addNewTeacher(teacher);
        return "redirect:/teacher";
    }
    @RequestMapping(value = "/newteachertable")
    public String newApprenticeTable(){
        return "administrator/newteacher";
    }

    @RequestMapping(value = "/updateteacher", method = RequestMethod.POST)
    public String updateTeacher(@ModelAttribute Teacher teacher){
        teacherService.updateTeacher(teacher);
        return "redirect:/teacher";
    }
    @RequestMapping(value = "/deleteteacher", method = RequestMethod.POST)
    public void deleteTeacher(@RequestParam(value = "teacherid") long teacherId){
        teacherService.deleteTeacherById(teacherId);
    }
}
