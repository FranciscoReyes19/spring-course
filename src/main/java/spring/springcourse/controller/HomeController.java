package spring.springcourse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(){
        //return "redirect:/index";
        //return "redirect:https://www.google.com";
        return "forward:/perfil"; //no cambia URL
    }
}
