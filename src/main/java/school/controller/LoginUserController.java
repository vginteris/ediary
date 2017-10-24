package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import school.model.LoginUser;
import school.service.LoginSecurityService;
import school.service.UserService;
import school.util.UserValidator;

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

}
