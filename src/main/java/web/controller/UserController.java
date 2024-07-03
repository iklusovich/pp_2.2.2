package web.controller;

import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String showAllUsers(Model model) {
        model.addAttribute("allUsers", userService.getAll());
        return "index";
    }

    @GetMapping("/addNewUser")
    public String addNewUser(Model model) {
        model.addAttribute("addUser", new User());
        return "add-user";
    }

    @GetMapping("show/{id}")
    public String showUser(Model model, @PathVariable int id) {
        model.addAttribute("user", userService.showUser(id));
        return "show-user";
    }

    @PostMapping()
    public String createUser(@ModelAttribute("addUser") User user) {
        userService.add(user);
        return "redirect:/";
    }

    @GetMapping("/edit")
    public String editUser(Model model, @RequestParam(value = "id") int id) {
        model.addAttribute("addUser", userService.showUser(id));
        return "edit-user";
    }

    @PostMapping("/{id}")
    public String updateUser(@ModelAttribute("addUser") User user) {
        userService.updateUser(user);
        return "redirect:/";
    }

    @GetMapping("delete")
    public String deletedUser( @RequestParam int id) {
        userService.deleteUser(id);
        return "redirect:/";
    }
}