package com.ComputerEngineeringDesign.Thesis.user.services.concretes;

import com.ComputerEngineeringDesign.Thesis.user.entities.User;
import com.ComputerEngineeringDesign.Thesis.user.repositories.UserDao;
import com.ComputerEngineeringDesign.Thesis.user.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Override
    public List<User> findAllUsers() {
        return userDao.findAll();
    }
}
