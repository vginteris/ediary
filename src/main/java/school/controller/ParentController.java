package school.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import school.model.Parent;
import school.service.ParentService;

import java.util.List;

@Controller
public class ParentController {
    @Autowired
    ParentService parentService;

    @RequestMapping(value = "/parent", method = RequestMethod.GET)
    public ModelAndView getAllParent(){
        ModelAndView model = new ModelAndView("administrator/parent");
        List<Parent> parentList = parentService.getAllParent();
        return model.addObject("parentList", parentList);
    }
    @RequestMapping(value = "/newaparent",method = RequestMethod.POST)
    public String addNewParent(@ModelAttribute Parent parent){
        parentService.addNewParent(parent);
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
    public void deleteParent(@RequestParam(value = "parentid") long parentid){
        parentService.deleteParentById(parentid);
    }

}
