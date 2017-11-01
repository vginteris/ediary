package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import school.model.LoginUser;
import school.model.UserRole;
import school.service.LoginSecurityService;
import school.service.UserRoleService;
import school.service.UserService;
import school.util.UserValidator;

import java.util.List;

@Controller
public class LoginUserController {
    @Autowired
    UserService userService;
    @Autowired
    LoginSecurityService securityService;
    @Autowired
    UserValidator userValidator;
    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    UserRoleService userRoleService;

    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model){
        model.addAttribute("userForm", new LoginUser());
        return "registration";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@ModelAttribute("userForm")LoginUser userForm, BindingResult bindingResult, Model model){
        userValidator.validate(userForm, bindingResult);
        if (bindingResult.hasErrors()){
            return "registration";
        }
        userService.insertNewUser(userForm);
        securityService.login(userForm.getUsername(),userForm.getPasswordComfirm());
        return "redirect:/login";
    }
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error){
        if (error!=null){
            model.addAttribute("error","wrong username or password");
        }
        return "login";
    }
    @RequestMapping(value = "/newusernametable", method = RequestMethod.GET)
    public ModelAndView getRoleforNewUsername(){
        ModelAndView model = new ModelAndView("administrator/alluser");
        List<UserRole> roleList = userRoleService.getAllUserRoles();
        model.addObject("roleList", roleList);
        List<LoginUser> userList = userService.getAllUser();
        model.addObject("userList",userList);
        return model;
    }
    @RequestMapping(value = "/insertnewuser", method = RequestMethod.POST)
    public String insertNewUser( @ModelAttribute LoginUser loginUser, @ModelAttribute UserRole userRole){
        loginUser.setUserRole(userRoleService.getUserRoleByID(userRole.getRoleid()));
        userService.insertNewUserAndGetID(loginUser);
        return "redirect:/newusernametable";

    }

}
