package com.ComputerEngineeringDesign.Thesis.generic.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RestResponse<T> implements Serializable {
    private T data;
    private Date responseDate;
    private String message;
    private boolean isSuccess;

    public RestResponse(T data, boolean isSuccess){
        this.data = data;
        this.isSuccess = isSuccess;
        this.responseDate = new Date();
    }

    public static <T> RestResponse<T> success(T data){
        return new RestResponse<>(data, true);
    }
    public static<T> RestResponse<T> error(T data){
        return new RestResponse<>(data, false);
    }
    public static<T> RestResponse<T> empty(){
        return new RestResponse<>(null, true);
    }
 }
