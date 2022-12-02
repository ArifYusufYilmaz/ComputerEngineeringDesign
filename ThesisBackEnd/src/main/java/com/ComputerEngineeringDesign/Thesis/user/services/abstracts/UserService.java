package com.ComputerEngineeringDesign.Thesis.user.services.abstracts;

import com.ComputerEngineeringDesign.Thesis.user.entities.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
}
