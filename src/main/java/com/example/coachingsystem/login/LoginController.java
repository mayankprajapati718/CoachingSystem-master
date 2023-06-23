package com.example.coachingsystem.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
    @GetMapping ("/")
    public String gotoLoginPage(ModelMap modelMap){
modelMap.put("name","Mayank");
        return "welcome";
    }

}
