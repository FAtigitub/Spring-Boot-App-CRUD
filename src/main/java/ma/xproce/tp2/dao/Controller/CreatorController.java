package ma.xproce.tp2.dao.Controller;


import ma.xproce.tp2.dao.entities.Creator;
import ma.xproce.tp2.dao.service.CreatorManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller

public class CreatorController {

    @Autowired
    private CreatorManager creatorManager;

    // Afficher la liste des créateurs
    @GetMapping("/list")
    public String showCreatorsList(Model model) {
        List<Creator> creators = creatorManager.getAllCreators();
        model.addAttribute("listcreators", creators);
        return "list";
    }


    @GetMapping("detailCreator")
    public String detailCreator(Model model,
                                @RequestParam(name = "id") Integer id) {

        Creator creator = creatorManager.getCreatorById(id);
        model.addAttribute("creatorWithDetails", creator);
        return "detailCreator" ;

    }





    @GetMapping("/add")
    public String showAddCreatorForm(Model model) {
        model.addAttribute("creator", new Creator());
        return "add";
    }

    @PostMapping("/add")
    public String addCreator(@ModelAttribute("creator") Creator creator) {
        creatorManager.saveCreator(creator);
        return "redirect:/list";
    }





    @GetMapping("/update/{id}")
    public String showUpdateCreatorForm(@PathVariable("id") Integer id, Model model) {
        Creator creator = creatorManager.getCreatorById(id);
        model.addAttribute("creator", creator);
        return "update";
    }

    @PostMapping("/update/{id}")
    public String updateCreator(@PathVariable("id") Integer id, @ModelAttribute("creator") Creator updatedCreator) {
        Creator existingCreator = creatorManager.getCreatorById(id);
        if (existingCreator != null) {
            existingCreator.setName(updatedCreator.getName());
            existingCreator.setEmail(updatedCreator.getEmail());
            creatorManager.saveCreator(existingCreator);
        }
        return "redirect:/list";
    }




    @GetMapping("/delete/{id}")
    public String showDeleteConfirmation(@PathVariable("id") Integer id, Model model) {
        Creator creator = creatorManager.getCreatorById(id);
        model.addAttribute("creator", creator);
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String deleteCreator(@PathVariable("id") Integer id) {
        creatorManager.deleteCreator(id);
        return "redirect:/list";
    }
}












