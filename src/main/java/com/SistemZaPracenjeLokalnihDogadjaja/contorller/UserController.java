package com.SistemZaPracenjeLokalnihDogadjaja.contorller;

import com.SistemZaPracenjeLokalnihDogadjaja.model.Authority;
import com.SistemZaPracenjeLokalnihDogadjaja.model.User;
import com.SistemZaPracenjeLokalnihDogadjaja.services.AuthorityService;
import com.SistemZaPracenjeLokalnihDogadjaja.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private AuthorityService authorityService;


    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @GetMapping("/register-user")
    public String registerUser(Model model) {
        User user = new User();
        List<Authority> authorities = authorityService.findAllAuthority();
        model.addAttribute("user", user);
        model.addAttribute("authorities", authorities);
        return "register_user";
    }

    @GetMapping("/{id}")
    public User findUserById(@PathVariable(name = "id") long id) {
        return userService.findUserById(id);
    }

    @GetMapping
    public String findAllUsers(Model model) {
        List<User> users = userService.findAllUsers();
        model.addAttribute("users",users);
        return "users";
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute User user) {
        userService.saveUser(user);
        return "redirect:/events";
    }


    @GetMapping("/delete-user/{id}")
    public String deleteUser(@PathVariable(name = "id") long id) {
        User user = userService.findUserById(id);
        userService.deleteUser(user);
        return "redirect:/users";
    }


}
