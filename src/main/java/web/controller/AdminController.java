package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.model.Role;
import web.model.User;
import web.service.RoleService;
import web.service.UserService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = {""})
    public String printUsers(Model model) {
        List<User> userList = userService.userList();
        model.addAttribute("users", userList);
        return "users";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "addUser";
    }

    @PostMapping("admin/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/admin/";
    }

    @GetMapping("/edit/{id}")
    public String editUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getById(id));
        return "editUser";
    }

    @PostMapping("/admin/edit")
    public String editUser(@ModelAttribute("user") User user) {
        userService.edit(user);
        return "redirect:/admin/";
    }

//    @PostMapping("/edit")
//    public String editUser(@ModelAttribute("user") User user, @PathVariable("userId") Long id) {
//        User dbUser = userService.getById(id);
//        userService.edit(user);
//        return "redirect:/admin/";
//    }


    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") long id) {
        userService.delete(userService.getById(id));
        return "redirect:/admin/";
    }

}