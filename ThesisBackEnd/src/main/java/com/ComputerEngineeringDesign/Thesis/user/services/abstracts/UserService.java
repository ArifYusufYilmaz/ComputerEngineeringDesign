package com.ComputerEngineeringDesign.Thesis.user.services.abstracts;

import com.ComputerEngineeringDesign.Thesis.user.dtos.UserLoginDto;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserResponseDto;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.user.entities.User;

import java.util.List;

public interface UserService {
    List<UserResponseDto> getAllUsers();

    UserResponseDto getOneUser(Long id);

    UserResponseDto createOneUser(UserSaveRequestDto userSaveRequestDto);

    UserResponseDto updateOneUser(Long id, UserUpdateRequestDto userUpdateRequestDto);

    void deleteOneUser(Long id);

    UserResponseDto getSignedUpUser(UserLoginDto userLoginDto);
}
