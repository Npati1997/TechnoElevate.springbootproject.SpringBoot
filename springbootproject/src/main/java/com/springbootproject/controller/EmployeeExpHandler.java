package com.springbootproject.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.springbootproject.dto.EmployeeResponse;
import com.springbootproject.exceptions.EmployeeExp;

@RestControllerAdvice
public class EmployeeExpHandler {
	
	@ExceptionHandler(EmployeeExp.class)
	public EmployeeResponse exceptionHandler(EmployeeExp employeeExp) {
		
		EmployeeResponse response=new EmployeeResponse();
		response.setStatusCode(500);
		response.setMsg("Found duplicate Value ");
		response.setDescription("Data Already present");
		return response;
		
	}

}
