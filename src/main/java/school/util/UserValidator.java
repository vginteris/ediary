package school.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import school.model.LoginUser;
import school.service.UserService;

@Component
public class UserValidator implements Validator {
    @Autowired
    UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return LoginUser.class.equals(aClass);
    }

    @Override
    public void validate(Object ouser, Errors errors) {
        LoginUser user = (LoginUser) ouser;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "EmptySpace");

        //jei egzistuoja vartotojas
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "Warning.dublicate.username");
        }


        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "EmptySpace");

        if (user.getUsername().length() <= 3 || user.getUsername().length() >= 32) {
            errors.rejectValue("username", "Size.username");
        }
        if (user.getPassword().length() < 3 || user.getPassword().length() >= 31) {
            errors.rejectValue("password", "Size.password");
        }

    }
}
