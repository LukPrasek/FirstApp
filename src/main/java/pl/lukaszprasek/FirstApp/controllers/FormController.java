package pl.lukaszprasek.FirstApp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.lukaszprasek.FirstApp.controllers.models.CalculatorForm;
import pl.lukaszprasek.FirstApp.controllers.models.LoginForm;

import javax.validation.Valid;

@Controller
public class FormController {

    @GetMapping("/register")

    public String register(Model model) {
        model.addAttribute("registerForm", new LoginForm());
        return "register";
    }

    @PostMapping("/register")

    public String postRegister(@ModelAttribute @Valid LoginForm registerForm,
                               BindingResult bindingResult,
                               Model model) {
        if (bindingResult.hasErrors()) {
            return "register";
        }

        model.addAttribute("info", "Ojojoj");

        return "register";

    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    @PostMapping("/login")// do wysylania formularza

    public String postLogin(@ModelAttribute @Valid LoginForm loginForm, BindingResult bindingResult,
                            Model model) {
        if (bindingResult.hasErrors()) {
            return "login";
        }
        boolean isLoginCorrect = loginForm.getLogin().equals("admin") && loginForm.getPassword().equals("admin");
        model.addAttribute("isLoginCorrect", isLoginCorrect);

        return "login";
    }

    @GetMapping("/calculator")
    public String getCalculator(Model model) {
        model.addAttribute("calculatorForm", new CalculatorForm());
        return "calculator";

    }

    //    @PostMapping("/calculator")// do wysylania formularza
//
//    public String postCalculator(@ModelAttribute @Valid CalculatorForm calculatorForm, BindingResult bindingResult,
//                                 Model model) {
//        if (bindingResult.hasErrors()) {
//            return "calculator";
//        }
//        boolean isLoanAccepted = ((calculatorForm.getLoanAmount() / calculatorForm.getMonths()) <
//                (0.3 * (calculatorForm.getSalary() - calculatorForm.getExpenses())));
//
//        model.addAttribute("isLoanAccepted", isLoanAccepted);
//        if (isLoanAccepted) {
//            double installments = calculatorForm.getLoanAmount() / calculatorForm.getMonths();
//            model.addAttribute("installments", installments);
//        }
//
//        return "calculator";
//    }
    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public String submit( @ModelAttribute @Valid CalculatorForm calculatorForm,
                          BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "calculator";
        }
        boolean isLoanAccepted = (calculatorForm.getLoanAmount() / calculatorForm.getMonths()) <
                (0.3 * (calculatorForm.getSalary() - (calculatorForm.getExpenses())));
        model.addAttribute("isLoanAccepted", isLoanAccepted);
        if (isLoanAccepted) {
            double installments = calculatorForm.getLoanAmount() / calculatorForm.getMonths();
            model.addAttribute("installments", installments);
        }
        return "calculatorAnswer";
    }
}