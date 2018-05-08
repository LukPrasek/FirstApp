package pl.lukaszprasek.FirstApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ControllerLogin {
    @GetMapping("/login/")//http://localhost:8080/login
    @ResponseBody
    private String giveName(){
        return "Podaj imie";
    }
}
