package com.ComputerEngineeringDesign.Thesis.user.controllers;

import com.ComputerEngineeringDesign.Thesis.user.entities.User;
import com.ComputerEngineeringDesign.Thesis.user.repositories.UserDao;
import com.ComputerEngineeringDesign.Thesis.user.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<User> GetAllUsers(){
        return userService.findAllUsers();
    }
}
