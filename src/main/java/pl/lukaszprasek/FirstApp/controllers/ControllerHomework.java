package pl.lukaszprasek.FirstApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lukaszprasek.FirstApp.controllers.models.PacientForm;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class ControllerHomework {

    //***Sposob 1******
    @GetMapping("/{isAdult}")//http://localhost:8080/about/me
    public String isAdult(@PathVariable("isAdult") boolean isAdult, Model model) {
        if (isAdult) {
            model.addAttribute("isAdult", "Mozesz wejsc na strone");
        } else {
            model.addAttribute("isAdult", "Nie mozesz wejsc na strone, sorry zboczencu");
        }
        return "adult";
    }


    //************SPOSOB 2**********//
    @GetMapping("/entrance")
    public String register() {
        return "registration";
    }

    @PostMapping("/entrance")
    public String register(@RequestParam("cardNumber") String number,
                           @RequestParam("password") String password,
                           Model model) {
        Pattern pattern = Pattern.compile("[0-9]{6}");
        Matcher matcher = pattern.matcher(number);
        if (!matcher.matches()) {
            model.addAttribute("info", "Niepoprawny numer karty");
        } else if (matcher.matches() && !password.isEmpty()) {
            model.addAttribute("info", "Udalo sie zalogowac");
        } else {
            model.addAttribute("info", "Bledny login lub haslo");
        }

        return "registration";
    }

    //************SPOSOB 3**********//
    @GetMapping("/entrance/login")
    public String login(Model model) {
        model.addAttribute("pacientForm", new PacientForm());
        return "loginToMed";
    }

    @PostMapping("/entrance/login")
    public String register(@ModelAttribute PacientForm pacientForm, Model model) {
        Pattern pattern = Pattern.compile("[0-9]{6}");
        Matcher matcher = pattern.matcher(String.valueOf(pacientForm.getCardNumber()));
        if (!matcher.matches()) {
            model.addAttribute("info", "Niepoprawny numer karty");
        } else if (matcher.matches() && !pacientForm.getPassword().isEmpty()) {
            model.addAttribute("info", "Udalo sie zalogowac");
        } else {
            model.addAttribute("info", "Bledny login lub haslo");
        }

        return "loginToMed";
    }
}
