package com.ComputerEngineeringDesign.Thesis.user.dtos;

import lombok.Data;

@Data
public class UserSaveRequestDto {

    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
}
