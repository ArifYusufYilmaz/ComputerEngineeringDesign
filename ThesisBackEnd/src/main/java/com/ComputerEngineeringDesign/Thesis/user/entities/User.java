package com.ComputerEngineeringDesign.Thesis.user.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name= "users")
@Data
public class User {
    @Id
    @SequenceGenerator(name = "User",sequenceName = "USER_ID_SEQ")
    @GeneratedValue(generator = "User", strategy = GenerationType.SEQUENCE)
    private Long id;

    private String userFirstName;
    private String userLastName;
    private String userEmail;
    private String userPassword;
}
