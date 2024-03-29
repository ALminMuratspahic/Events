package com.SistemZaPracenjeLokalnihDogadjaja.contorller;

import com.SistemZaPracenjeLokalnihDogadjaja.model.User;
import com.SistemZaPracenjeLokalnihDogadjaja.security.roles.Role;
import com.SistemZaPracenjeLokalnihDogadjaja.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register")
    public String registerUser(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "register_user";
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable(name = "id") long id) {
        return userService.findUserById(id);
    }

    @GetMapping
    @PreAuthorize(value = "ROLE_ADMIN")
    public String findAllUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users", users);
        return "users";
    }

    @PostMapping()
    public String saveUser(@ModelAttribute User user) {
        user.setRole(Role.ROLE_USER);
        userService.saveUser(user);
        return "redirect:/events";
    }

    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable(name = "id") long id) {
        User user = userService.findUserById(id);
        userService.deleteUser(user);
        return "redirect:/users";
    }


}
