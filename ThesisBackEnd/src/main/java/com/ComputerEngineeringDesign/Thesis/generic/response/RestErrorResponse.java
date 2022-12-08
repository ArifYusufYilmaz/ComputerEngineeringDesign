package com.ComputerEngineeringDesign.Thesis.generic.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.Date;
@Data
@AllArgsConstructor
public class RestErrorResponse {
  private String message;
  private String detail;
  private Date errorDate;

}
