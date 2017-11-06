package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import school.model.*;
import school.service.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ApprenticeController {
    @Autowired
    ApprenticeService apprenticeService;
    @Autowired
    ParentService parentService;
    @Autowired
    UserService userService;
    @Autowired
    SchoolClassService schoolClassService;
    @Autowired
    UserRoleService userRoleService;


    @RequestMapping(value = "/apprentice", method = RequestMethod.GET)
    public ModelAndView getAllApprentice() {
        ModelAndView model = new ModelAndView("administrator/apprentice");
        List<Apprentice> apprenticeList = apprenticeService.getAllAprentice();
        return model.addObject("apprenticeList", apprenticeList);
    }

    @RequestMapping(value = "/newapprentice", method = RequestMethod.POST)
    public String addNewApprentice(@ModelAttribute Apprentice apprentice, @ModelAttribute SchoolClass schoolClass, @ModelAttribute Parent parent,
                                   @ModelAttribute LoginUser loginUser, @ModelAttribute UserRole userRole) {
//        schoolClass.setSchoolClassid(schoolClassService.addnewclass(schoolClass));
//        parent.setParentid(parentService.addNewParentAndReturnId(parent));
        loginUser.setUserRole(userRoleService.getUserRoleByID(userRole.getRoleid()));
        loginUser.setUserid(userService.insertNewUserAndGetID(loginUser));

        apprentice.setLoginUser(loginUser);
        apprentice.setSchoolClass(schoolClassService.getSchoolClassByID(schoolClass.getSchoolClassid()));
        apprentice.setApprentieParent(parentService.getParentById(parent.getParentid()));

        apprenticeService.addNewApprentice(apprentice);
        return "redirect:/apprentice";
    }

    @RequestMapping(value = "/newusertable")
    public ModelAndView newApprenticeTable() {
        ModelAndView model = new ModelAndView("administrator/newapprentice");
        List<Parent> parentList = parentService.getAllParent();
        model.addObject("parentlist", parentList);

        List<SchoolClass> schoolClassList = schoolClassService.getAllSchoolClass();
        model.addObject("classlist", schoolClassList);

        List<UserRole> roleList = userRoleService.getAllUserRoles();
        model.addObject("rolelist", roleList);
        return model;
    }

    @RequestMapping(value = "/updateapprentice", method = RequestMethod.POST)
    public String updateApprentice(@ModelAttribute Apprentice apprentice, @ModelAttribute Parent parent,
                                   @ModelAttribute LoginUser loginUser, @ModelAttribute SchoolClass schoolClass) {
        apprentice.setApprentieParent(parentService.getParentByName(parent.getParentName()));
        apprentice.setLoginUser(userService.findByUsername(loginUser.getUsername()));
        apprentice.setSchoolClass(schoolClassService.getSchoolClasByName(schoolClass.getClassName()));
        apprenticeService.updateApprentice(apprentice);
        return "redirect:/apprentice";
    }

    @RequestMapping(value = "/deleteapprentice", method = RequestMethod.POST)
    public void deleteApprentice(@RequestParam(value = "apprenticeid") long apprenticeId) {
        apprenticeService.deleteApprenticeById(apprenticeId);
    }

    @RequestMapping(value = "/uploadapprentices", method = RequestMethod.POST)
    public String uploadFileAndWriteApprentie(@RequestParam(value = "fileap") MultipartFile fileap, ModelMap modelMap){
       BufferedReader br;
        try {

            String line;
            InputStream is = fileap.getInputStream();
            br = new BufferedReader(new InputStreamReader(is));
            int linenumber=0;
            Apprentice apprentice;
            while ((line = br.readLine()) != null) {
               String[] array = line.split(",");
              if (linenumber !=0) {
                 apprentice = new Apprentice();
                 apprentice.setApprenticeName(array[0]);
                 apprentice.setApprenticeSurname(array[1]);
                 apprentice.setSchoolClass(schoolClassService.getSchoolClassByID(Long.parseLong(array[2])));
                 apprentice.setApprentieParent(parentService.getParentById(Long.parseLong(array[3])));
                 apprentice.setLoginUser(userService.findByUsername(array[4]));
                 apprenticeService.addNewApprentice(apprentice);
              }
              linenumber++;
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }


        return "redirect:/apprentice";
    }


}
