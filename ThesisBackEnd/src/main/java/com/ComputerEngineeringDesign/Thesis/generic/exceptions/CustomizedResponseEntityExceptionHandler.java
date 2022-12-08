package com.ComputerEngineeringDesign.Thesis.generic.exceptions;

import com.ComputerEngineeringDesign.Thesis.generic.response.RestErrorResponse;
import com.ComputerEngineeringDesign.Thesis.generic.response.RestResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
/*
* ResponseEntity->RestResponse->RestErrorResponse
*
* */
@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {
    @ExceptionHandler   //500, to find all the exceptions.
    public final ResponseEntity<Object> handleAllExcepitons(Exception ex, WebRequest webRequest){
        String message = ex.getMessage();
        String detail = webRequest.getDescription(false);
        return getResponseEntity(message, detail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler
    public final ResponseEntity<Object> handleBusinessExcepitons(BusinessException businessEx,WebRequest webRequest){
        String message = businessEx.getBaseErrorMessage().getMessage();
        String detail = webRequest.getDescription(false);
        return getResponseEntity(message, detail, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler   // 404, to find when we get the error not found ex.
    public final ResponseEntity<Object> handleItemNotFoundExceptions(ItemNotFoundException iNFEx, WebRequest webRequest){
        String message = iNFEx.getBaseErrorMessage().getMessage();
        String detail = webRequest.getDescription(false);
        return getResponseEntity(message, detail, HttpStatus.NOT_FOUND);
    }

    private ResponseEntity getResponseEntity(String message, String detail, HttpStatus httpStatus){
        Date errorDate = new Date();
        RestErrorResponse restErrorResponse = new RestErrorResponse(message, detail,errorDate);
        RestResponse<RestErrorResponse> restResponse = RestResponse.error(restErrorResponse);

        ResponseEntity<Object> responseEntity = new ResponseEntity<>(restResponse, httpStatus);
        return responseEntity;
    }
}
