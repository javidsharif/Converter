package com.sharifaliyev.converter.controllers;

import com.sharifaliyev.converter.dto.UserRegistrationDto;
import com.sharifaliyev.converter.entities.Person;
import com.sharifaliyev.converter.services.AccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

    @ModelAttribute("user")
    public UserRegistrationDto userRegistrationDto() {
        return new UserRegistrationDto();
    }

    @GetMapping("/login")
    public String showLoginForm(Model model) {
        return "login";
    }

    @GetMapping("/registration")
    public String showRegistrationForm(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String registerUserAccount(@ModelAttribute("user") @Valid UserRegistrationDto userDto, BindingResult result) {
        Person existing = accountService.findByEmail(userDto.getEmail());
        if(existing != null) {
            result.rejectValue("email", null, "Account with this email already registered!");

        }
        if(!userDto.getTerms()) {
            result.rejectValue("terms", null, "You need to accept the license agreement");
        }

        if(result.hasErrors()) {
            return "registration";
        }


    Person person =  accountService.save(userDto);
        if(person == null) {
            result.rejectValue("password", null, "Password is not correct");
        }
        if(result.hasErrors()) {
            return "registration";
        }

        return "redirect:/";
    }

}
