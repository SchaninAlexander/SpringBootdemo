package com.example.SpringBootdemo.controller;

import com.example.SpringBootdemo.model.User;
import com.example.SpringBootdemo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class UserController {

    private final UserService userService;


    public UserController(UserService userService) {
                this.userService = userService;
    }


    @GetMapping("/users")
    public String showAllUsers(Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "all-users";
    }

    @GetMapping("/user-create")
    public String createUserForm(Model model){
        model.addAttribute("user", new User());
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(@ModelAttribute("user") User user){
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/user-delete")
    public String deleteUser(@RequestParam("id") int id) {
        userService.deleteById(id);
        return "redirect:/users";
    }

    @GetMapping("/user-update")
    public String updateUserForm(@RequestParam("id") int id, Model model) {
        model.addAttribute("user",userService.findById(id));
        return "user-update";
    }


    @PostMapping("/user-update")
    public String updateUser(@ModelAttribute("user")  User user){
        userService.updateUser(user);
        return "redirect:/users";


    }
}