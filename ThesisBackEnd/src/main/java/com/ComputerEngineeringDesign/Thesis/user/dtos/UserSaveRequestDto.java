package com.ComputerEngineeringDesign.Thesis.user.dtos;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Data
public class UserSaveRequestDto {
    @NotBlank(message= "userFirstName is Mandatory")
    @NotEmpty
    private String userFirstName;
    @NotBlank(message= "userLastName is Mandatory")
    @NotEmpty
    private String userLastName;
    @NotBlank(message= "userEmail is Mandatory")
    @NotEmpty
    @Email(message = "Should have been email format")
    private String userEmail;
    @NotBlank(message= "userPassword is Mandatory")
    @NotEmpty
    private String userPassword;
}
