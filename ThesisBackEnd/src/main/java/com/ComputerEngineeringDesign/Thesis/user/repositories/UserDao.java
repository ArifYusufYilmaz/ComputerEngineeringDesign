package com.ComputerEngineeringDesign.Thesis.user.repositories;

import com.ComputerEngineeringDesign.Thesis.user.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User, Long> {
}
