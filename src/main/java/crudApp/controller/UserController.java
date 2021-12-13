package crudApp.controller;

import crudApp.dao.UserDAO;
import crudApp.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private UserDAO userDAO;

    @Autowired
    public UserController(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    @GetMapping("/")
    public String allUsers (Model model) {
        model.addAttribute("users", userDAO.allUsers());
        return "users";
    }

    @GetMapping("/{id}")
    public String showUser(@PathVariable int id, Model model) {
        model.addAttribute("user", userDAO.userById(id));
        return "user";
    }

    @GetMapping("/newUser")
    public String newUser (Model model) {
        model.addAttribute("user", new User());

        return "newUser";
    }

    @PostMapping()
    public String createUser(@ModelAttribute ("user") User user) {
        userDAO.add(user);
        return "redirect:/";
    }

    @GetMapping("/{id}/edit")
    public String edit (Model model, @PathVariable int id) {
        model.addAttribute("user", userDAO.userById(id));
        return "edit";
    }

    @PatchMapping("/{id}")
    public String editUser (@ModelAttribute User user, @PathVariable int id) {
        userDAO.edit(id);
        return "redirect:/";
    }

    @DeleteMapping("/{id}")
    public String delete (@PathVariable int id) {
        userDAO.delete(id);
        return "redirect:/";
    }
}
