package pl.lukaszprasek.FirstApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.lukaszprasek.FirstApp.controllers.models.LoginForm;

@Controller
public class FormController {

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")// do wysylania formularza

    public String registerPost(@RequestParam("login") String login,
                               @RequestParam("password") String password,
                               Model model) {//mamy tutaj argumenty, bo musimy wskazac Springowi co ma nasluchiwac
        String message;
        if (login.isEmpty() || password.isEmpty()) {
            message = "Rejestracja niepomyslna";
        } else {
            message = "Rejestracja powiodla sie";
        }
        model.addAttribute("info", message);//info to nazwa zmiennej z templatki
        return "register";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }

//    @PostMapping("/login")// do wysylania formularza
//
//    public String postLogin(@RequestParam("login") String login,
//                            @RequestParam("password") String password,
//                            Model model) {
//
//        boolean isLoginCorrect = login.equals("admin") && password.equals("admin");
//        model.addAttribute("isLoginCorrect", isLoginCorrect);
//
//
//        return "login";
//    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }
//    @PostMapping("/login")// do wysylania formularza
//
//    public String postLogin(@ModelAttribute LoginForm loginForm, Model model) {
//
//        boolean isLoginCorrect = loginForm.getLogin().equals("admin") && loginForm.getPassword().equals("admin");
//        model.addAttribute("isLoginCorrect", isLoginCorrect);
//
//        return "login";
//    }
}