package com.ComputerEngineeringDesign.Thesis.user.controllers;

import com.ComputerEngineeringDesign.Thesis.generic.response.RestResponse;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserLoginDto;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserResponseDto;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserSaveRequestDto;
import com.ComputerEngineeringDesign.Thesis.user.dtos.UserUpdateRequestDto;
import com.ComputerEngineeringDesign.Thesis.user.services.abstracts.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;
    @GetMapping
    public ResponseEntity getAllUsers(){
        List<UserResponseDto> userResponseDtoList =  userService.getAllUsers();
        return ResponseEntity.ok(RestResponse.success(userResponseDtoList));
    }
    @PostMapping("/login")
    public ResponseEntity getSignedUpUser(@RequestBody UserLoginDto userLoginDto){
        UserResponseDto userResponseDto = userService.getSignedUpUser(userLoginDto);
        return ResponseEntity.ok(RestResponse.success(userResponseDto));
    }
    @GetMapping("/{id}")
    public ResponseEntity getOneUser(@PathVariable Long id){
        return ResponseEntity.ok(RestResponse.success(userService.getOneUser(id)));
    }

    @PostMapping("/signUp")
    public ResponseEntity createOneUser(@Valid @RequestBody UserSaveRequestDto userSaveRequestDto){
        UserResponseDto userResponseDto = userService.createOneUser(userSaveRequestDto);

        return  ResponseEntity.ok(RestResponse.success(userResponseDto));

    }
    @PutMapping("/{id}")
    public ResponseEntity updateOneUser(@PathVariable Long id, @RequestBody UserUpdateRequestDto userUpdateRequestDto){

        UserResponseDto userResponseDto = userService.updateOneUser(id,userUpdateRequestDto);
        return ResponseEntity.ok( RestResponse.success(userResponseDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteOneUserById(@PathVariable Long id){
        userService.deleteOneUser(id);
        return ResponseEntity.ok(RestResponse.empty());
    }
}
