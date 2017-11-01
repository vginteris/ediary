package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import school.model.Apprentice;
import school.model.SchoolClass;
import school.service.ApprenticeService;
import school.service.SchoolClassService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class SchoolClassController {
    @Autowired
    SchoolClassService schoolClassService;
    @Autowired
    ApprenticeService apprenticeService;

    @RequestMapping(value = "/schoolclass", method = RequestMethod.GET)
    public ModelAndView getAllSchoolClass() {
        ModelAndView model = new ModelAndView("administrator/schoolclass");
        List<SchoolClass> classList = schoolClassService.getAllSchoolClass();
        model.addObject("classlist", classList);
        List<Apprentice> apprenticeList = apprenticeService.getApprenticeWithoutClass();
        model.addObject("apprenticelist", apprenticeList);
        return model;
    }

    @RequestMapping(value = "/insertnewclass", method = RequestMethod.POST, consumes = {"application/x-www-form-urlencoded"})
    public String insertNewSchoolClass(@ModelAttribute SchoolClass schoolClass, @RequestParam(value = "subject") Long[] apprenticeid) {
       schoolClass.setSchoolClassid( schoolClassService.addNewClassAndReturnId(schoolClass));
//        List<Apprentice> apprenticeList = new ArrayList<>();
        for (Long id:apprenticeid) {
            Apprentice apprentice = apprenticeService.getApprenticeByID(id);
            apprentice.setSchoolClass(schoolClass);
            apprenticeService.updateApprentice(apprentice);
        }

        return "redirect:/schoolclass";
    }
}
