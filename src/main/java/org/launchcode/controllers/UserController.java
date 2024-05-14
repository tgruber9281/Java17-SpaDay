package org.launchcode.controllers;

import jakarta.validation.Valid;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("user")
public class UserController {

    @GetMapping("add")
    public String displayAddUserForm(Model model) {
        model.addAttribute( new User());
        return "user/add";
    }

    @PostMapping("/add")
    public String processAddUserForm(Model model, @ModelAttribute @Valid User user, Errors errors, String verify) {
        System.out.println(errors);
//        model.addAttribute("verify", verify);
//        model.addAttribute("user", user);
//        model.addAttribute("errors", errors);
        if (!user.getPassword().equals(verify) || errors.hasErrors()) {
            model.addAttribute("error", "Passwords do not match");
            if (!user.getPassword().equals(verify)) {
                model.addAttribute("displayError", true);
            }
            return "user/add";
        }
        return "user/index";
    }
}