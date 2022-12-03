package com.ComputerEngineeringDesign.Thesis.user.controllers;

import com.ComputerEngineeringDesign.Thesis.user.dtos.UserResponseDto;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.user.entities.User;
import com.ComputerEngineeringDesign.Thesis.user.repositories.UserDao;
import com.ComputerEngineeringDesign.Thesis.user.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public List<UserResponseDto> getAllUsers(){
        return userService.getAllUsers();
    }
    @GetMapping("/{id}")
    public UserResponseDto getOneUser(@PathVariable Long id){
         return userService.getOneUser(id);
    }

    @PostMapping
    public UserResponseDto createOneUser(@RequestBody UserSaveRequestDto userSaveRequestDto){
        return userService.createOneUser(userSaveRequestDto);
    }
    @PutMapping("/{id}")
    public UserResponseDto updateOneUser(@PathVariable Long id, @RequestBody UserUpdateRequestDto userUpdateRequestDto){
        return userService.updateOneUser(id,userUpdateRequestDto);
    }
    @DeleteMapping("/{id}")
    public void deleteOneUserById(@PathVariable Long id){
        userService.deleteOneUser(id);
    }
}
