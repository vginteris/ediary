package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import school.model.Apprentice;
import school.service.ApprenticeService;

import java.util.List;

@Controller
public class ApprenticeController {
    @Autowired
    ApprenticeService apprenticeService;

    @RequestMapping(value = "/apprentice", method = RequestMethod.GET)
    public ModelAndView getAllApprentice(){
        ModelAndView model = new ModelAndView("administrator/apprentice");
        List<Apprentice> apprenticeList = apprenticeService.getAllAprentice();
        return model.addObject("apprenticeList", apprenticeList);
    }

    @RequestMapping(value = "/newapprentice",method = RequestMethod.POST)
    public String addNewApprentice(@ModelAttribute Apprentice apprentice){
        apprenticeService.addNewApprentice(apprentice);
        return "redirect:/apprentice";
    }
    @RequestMapping(value = "/newusertable")
    public String newApprenticeTable(){
        return "administrator/newapprentice";
    }
    @RequestMapping(value = "/updateapprentice", method = RequestMethod.POST)
    public String updateApprentice(@ModelAttribute Apprentice apprentice){
        apprenticeService.updateApprentice(apprentice);
        return "redirect:/apprentice";
    }
    @RequestMapping(value = "/deleteapprentice", method = RequestMethod.POST)
    public void deleteApprentice(@RequestParam(value = "apprenticeid") long apprenticeId){
        apprenticeService.deleteApprenticeById(apprenticeId);
    }


}
