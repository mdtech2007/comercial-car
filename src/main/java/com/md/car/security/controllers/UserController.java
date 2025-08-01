/*package com.md.car.security.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.md.car.exception.UserAlreadyExistException;
import com.md.car.security.models.User;
import com.md.car.security.services.RoleService;
import com.md.car.security.services.UserService;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MessageSource messageSource;

    @GetMapping("/security/users")
    public String getAll(Model model) {
        model.addAttribute("users", userService.findAll());
        return "/security/users";
    }

    @GetMapping("/security/user/{op}/{id}")
    public String editUser(@PathVariable Integer id, @PathVariable String op, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        model.addAttribute("userRoles", roleService.getUserRoles(user));
        model.addAttribute("userNotRoles", roleService.getUserNotRoles(user));
        return "/security/user" + op; //returns employeeEdit or employeeDetails
    }

    @PostMapping("/usersAddNew")
    public String addNew(User user, Model model) throws UserAlreadyExistException {
        userService.register(user);

//        RedirectView redirectView = new RedirectView("/login", true);
        model.addAttribute("registrationSuccess",
                "You can check your email to complete your registration");
        return "security/registrationSuccessful";
    }


} */
