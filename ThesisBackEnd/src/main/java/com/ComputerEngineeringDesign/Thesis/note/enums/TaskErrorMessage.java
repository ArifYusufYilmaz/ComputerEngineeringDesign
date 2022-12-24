package com.ComputerEngineeringDesign.Thesis.note.enums;

import com.ComputerEngineeringDesign.Thesis.generic.exceptions.BaseErrorMessage;

public enum TaskErrorMessage implements BaseErrorMessage {
    TASK_DOES_NOT_EXIST("Task does not exist"),
    ;
    private String message;
    TaskErrorMessage(String message){
        this.message = message;
    }
    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String toString() {
        return "TaskErrorMessage{" +
                "message='" + message + '\'' +
                '}';
    }
}
