package com.ComputerEngineeringDesign.Thesis.user.repositories;

import com.ComputerEngineeringDesign.Thesis.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findUserByUserFirstNameAndUserLastNameAndUserEmailAndUserPassword(String userFirstName, String userLastName, String userEmail, String userPassword);
}
