package pl.lukaszprasek.FirstApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;

@Controller
public class MainController {
    @GetMapping("/")

    public String index(Model model){
        List<String> names= Arrays.asList("Jacek", "Placek");
        model.addAttribute("name", "Lukasz");
        model.addAttribute("lastname", "Prasek");
        model.addAttribute("names",names);
        return "index";
    }
    @GetMapping("/can/i/{age}/{name}")
    @ResponseBody
    public String canI(@PathVariable("age") int age,
                       @PathVariable("name") String name){
        return age >= 18 ? name + ", możesz wejść do klubu" : name + ", no niestety";
    }

    @GetMapping("/club/{age}")
    public String dipa(@PathVariable("age") int age1,
                       Model model){
        model.addAttribute("age", age1);
        return "club";
    }
}

