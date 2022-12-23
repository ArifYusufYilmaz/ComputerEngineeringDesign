package com.ComputerEngineeringDesign.Thesis.user.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name= "users")
@Data
public class User {
    @Id
    @SequenceGenerator(name = "User",sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "User", strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(name="user_first_name", nullable = false)

    @NotBlank(message = "userFirstName is mandatory")
    @NotEmpty
    private String userFirstName;

    @Column(name="user_last_name", nullable = false)
    @NotEmpty
    @NotBlank(message = "userLastName is mandatory")
    private String userLastName;

    @Column(name="user_email", nullable = false)
    @NotEmpty
    @NotBlank(message = "userEmail is mandatory")
    @Email(message = "Should have been email format")
    private String userEmail;

    @Column(name="user_password", nullable = false)
    @NotEmpty
    @NotBlank(message = "userPassword is mandatory")
    private String userPassword;

}
