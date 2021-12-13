package crudApp.controller;

import crudApp.model.User;
import crudApp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String allUsers (Model model) {
        model.addAttribute("users", userService.allUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userService.userById(id));
        return "user";
    }

    @GetMapping("/newUser")
    public String newUser (Model model) {
        model.addAttribute("user", new User());

        return "newUser";
    }

    @PostMapping()
    public String createUser(@ModelAttribute ("user") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit (Model model, @PathVariable int id) {
        model.addAttribute("user", userService.userById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String editUser (@ModelAttribute User user, @PathVariable int id) {
        userService.edit(id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable int id) {
        userService.delete(id);
        return "redirect:/";
    }
}
