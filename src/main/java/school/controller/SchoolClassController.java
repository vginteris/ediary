package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import school.model.SchoolClass;
import school.service.ApprenticeService;
import school.service.SchoolClassService;

import java.util.List;

@Controller
public class SchoolClassController {
    @Autowired
    SchoolClassService schoolClassService;
    @Autowired
    ApprenticeService apprenticeService;

    @RequestMapping(value = "/schoolclass", method = RequestMethod.GET)
    public ModelAndView getAllSchoolClass(){
        ModelAndView model = new ModelAndView("administrator/schoolclass");
        List<SchoolClass> classList = schoolClassService.getAllSchoolClass();
        model.addObject("classlist", classList);
        return model;
    }
}
