package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import school.model.LoginUser;
import school.model.SchoolClass;
import school.model.SchoolSubject;
import school.model.Teacher;
import school.service.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class TeacherController {
    @Autowired
    TeacherService teacherService;
    @Autowired
    SubjectService subjectService;
    @Autowired
    SchoolClassService classService;
    @Autowired
    UserService userService;
    @Autowired
    ApprenticeService apprenticeService;
    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(value = "/teacher", method = RequestMethod.GET)
    public ModelAndView getAllTeacher() {
        ModelAndView model = new ModelAndView("administrator/teacher");
        List<Teacher> teacherList = teacherService.getAllTeacher();
        model.addObject("teacherList", teacherList);
        List<SchoolSubject> subjectList = subjectService.getAllSubject();
        Set<String> setSubject = new HashSet<>();
        subjectList.forEach(v-> setSubject.add(v.getSubjectName()));
        model.addObject("subjectList", setSubject);
        return model;
    }

    @RequestMapping(value = "/newapteacher", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
    public String addNewTeacher(@ModelAttribute Teacher teacher, @ModelAttribute SchoolClass schoolClass,
                                 @RequestParam(value = "subject") String[] subject, @RequestParam(value = "roleid") long roleid) {
        teacher.setSchoolClass(classService.checkClassOrCreatNew(schoolClass.getClassName()));

        String personalCode= String.valueOf(teacher.getPersonalCode());
        LoginUser loginUser = new LoginUser(personalCode,personalCode,personalCode);
        loginUser.setUserRole(userRoleService.getUserRoleByID(roleid));
        loginUser.setUserid(userService.insertNewUserAndGetID(loginUser));

        teacher.setLoginUser(userService.findByUsername(loginUser.getUsername()));
        teacher.setTeacherid(teacherService.addNewTeacherAndReturnId(teacher));
        for (String subid : subject) {
            SchoolSubject schoolSubject = new SchoolSubject(subid,teacher);  // sukuria nauja schoolsubject su name ir teacher
            subjectService.addNewSubject(schoolSubject);
        }
        return "redirect:/teacher";
    }

    @RequestMapping(value = "/newteachertable")
    public String newApprenticeTable() {
        return "administrator/newteacher";
    }

    @RequestMapping(value = "/updateteacher", method = RequestMethod.POST)
    public String updateTeacher(@ModelAttribute Teacher teacher) {
        teacherService.updateTeacher(teacher);
        return "redirect:/teacher";
    }

    @RequestMapping(value = "/deleteteacher", method = RequestMethod.POST)
    public void deleteTeacher(@RequestParam(value = "teacherid") long teacherId) {


        teacherService.deleteTeacherById(teacherId);
    }
}
