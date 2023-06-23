package com.example.coachingsystem.Coaching;

import jakarta.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.time.LocalDate;
import java.util.List;

//@Controller
@SessionAttributes("name")
public class CoachingController {
    private CoachingService coachingService;

    public CoachingController(CoachingService coachingService) {
        this.coachingService = coachingService;
    }
    @GetMapping("coaching")
    public String coaching(Model model){
        Coaching ce=new Coaching();
      List<Coaching>c= coachingService.findByUsername("mayank");
      model.addAttribute("c",c);
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
  coachingService.addStudent(ce.getUsername(),ce.getCourseName(), ce.getCompletionDate(),ce.isDone());

        return "redirect:coaching";
}
@GetMapping("delete-student")
    public String delete( @RequestParam int id) {
    coachingService.deleteById(id);
    return "redirect:coaching";
}
    @GetMapping("update-student")
    public String showupdate(@RequestParam int id,ModelMap map){
      Coaching c=  coachingService.findById(id);
        map.addAttribute("c",c);
return "addList";

}@PostMapping("update-student")
    public String update(@Valid Coaching ce, BindingResult result,ModelMap map){

        map.addAttribute("ce",ce);
        if(result.hasErrors()){
            return "addList";
        }
        coachingService.updateStudent(ce);

        return "redirect:coaching";
    }

}
