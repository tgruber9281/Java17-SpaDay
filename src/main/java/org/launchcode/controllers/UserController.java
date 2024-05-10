package org.launchcode.controllers;

import org.launchcode.data.UserData;
import org.launchcode.models.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Trevor Gruber
 */
@Controller
@RequestMapping("user")
public class UserController {
    
    @GetMapping("")
    public String displayUserList(Model model){
        model.addAttribute("users", UserData.getAll());
        model.addAttribute("title","List of Users");
        return "user/index";
    }
    
    @GetMapping("add")
    public String displayAddUserForm(Model model){
        model.addAttribute("title","Add User");
        return "user/add";
    }

    @PostMapping("add")
    public String processAddUserForm(Model model, @ModelAttribute User user, String verify) {
        model.addAttribute("user",user);
        if (user.getPassword().equals(verify)){
            model.addAttribute("title","Add User");
            UserData.add(user);
            model.addAttribute("users",UserData.getAll());
            return "redirect:/user";
        } else {
            model.addAttribute("error","Password did not match. Please try again.");
            return "user/add";
        }
    }
    @GetMapping("view/{userId}")
    public String viewUser(Model model, @PathVariable int userId) {
        User user = UserData.getById(userId);
        model.addAttribute("title","View " + user.getUsername());
        model.addAttribute("user", user);
        return "user/view";
    }
}
