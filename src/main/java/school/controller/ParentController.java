package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import school.model.Apprentice;
import school.model.LoginUser;
import school.model.Parent;
import school.service.ApprenticeService;
import school.service.ParentService;
import school.service.UserRoleService;
import school.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ParentController {
    @Autowired
    ParentService parentService;
    @Autowired
    ApprenticeService apprenticeService;
    @Autowired
    UserRoleService userRoleService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/parent", method = RequestMethod.GET)
    public ModelAndView getAllParent(){
        ModelAndView model = new ModelAndView("administrator/parent");
        List<Parent> parentList = parentService.getAllParent();
        model.addObject("parentList", parentList);
        List<Apprentice> apprenticeList = apprenticeService.getAllAprentice();
        model.addObject("apprenticeList",apprenticeList);
        return model;
    }
    @RequestMapping(value = "/newaparent",method = RequestMethod.POST)
    public String addNewParent(@ModelAttribute Parent parent
            ,@RequestParam(value = "children") long[] apprenticeid, @RequestParam(value = "roleid") long roleid){
        String personalCode= String.valueOf(parent.getPersonalCode());
        LoginUser loginUser = new LoginUser(personalCode,personalCode,personalCode);
        loginUser.setUserRole(userRoleService.getUserRoleByID(roleid));
        loginUser.setUserid(userService.insertNewUserAndGetID(loginUser));

        parent.setLoginUser(userService.findByUsername(loginUser.getUsername()));
        parent.setParentid(parentService.addNewParentAndReturnId(parent));


        for (long parid : apprenticeid) {
           apprenticeService.updateApprenticeParent(parent,parid);
        }
        return "redirect:/parent";
    }
    @RequestMapping(value = "/newparenttable")
    public String newParentTable(){
        return "administrator/newparent";
    }

    @RequestMapping(value = "/updateaparent", method = RequestMethod.POST)
    public String updateParent(@ModelAttribute Parent parent){
        parentService.updateParent(parent);
        return "redirect:/parent";
    }
    @RequestMapping(value = "/deleteparent", method = RequestMethod.POST)
    public String deleteParent(@ModelAttribute Parent parent){
        apprenticeService.setNullWhenDeleteParent(parent);
        parentService.deleteParentById(parent.getParentid());
        return "redirect:/parent";
    }

}
