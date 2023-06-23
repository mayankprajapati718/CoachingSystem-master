package com.example.coachingsystem.Coaching;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

@Controller
@SessionAttributes("name")
public class CoachingControllerJPA {
    @Autowired
    public CoachingRepository coachingRepository;

    @GetMapping("coaching")
    public String coaching(ModelMap model){
      List<Coaching>c= coachingRepository.findAll();
      model.put("c",c);

        return "coaching";
    }
    @GetMapping ("add-student")
    public String show(ModelMap map){
Coaching ce=new Coaching(6,"","Default Desc", LocalDate.now().plusYears(1),false);
map.put("ce",ce);
        return "addList";
    }

@PostMapping("add-student")
public String add(@Valid Coaching ce, BindingResult result,ModelMap map){
        map.addAttribute("ce",ce);
        if(result.hasErrors()){
            return "addList";
        }
  coachingRepository.save(ce);
        return "redirect:coaching";
}
@GetMapping("delete-student")
    public String delete( @RequestParam int id) {
    coachingRepository.deleteById(id);
    return "redirect:coaching";
}
    @GetMapping("update-student")
    public String showupdate(@RequestParam int id,ModelMap map){
      Coaching c=  coachingRepository.findById(id).get();
        map.addAttribute("ce",c);
return "addList";

}@PostMapping("update-student")
    public String update(@Valid Coaching ce, BindingResult result,ModelMap map){
        map.addAttribute("ce",ce);
        if(result.hasErrors()){
            return "addList";
        }
        coachingRepository.save(ce);

        return "redirect:coaching";
    }
}
