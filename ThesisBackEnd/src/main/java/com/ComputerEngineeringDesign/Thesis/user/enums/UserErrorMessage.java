package com.ComputerEngineeringDesign.Thesis.user.enums;

import com.ComputerEngineeringDesign.Thesis.generic.exceptions.BaseErrorMessage;

public enum UserErrorMessage implements BaseErrorMessage {
    USER_DOES_NOT_EXIST("User does not exist"),
    USER_ALREADY_EXIST("User cannot be duplicated"),
    USER_VALUES_COULD_NOT_MATCH("Values should be correct"),
            ;
    private String message;
    UserErrorMessage(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "UserErrorMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
