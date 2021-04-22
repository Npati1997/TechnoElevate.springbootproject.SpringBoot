package com.springbootproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springbootproject.dto.EmployeeBean;
import com.springbootproject.dto.EmployeeResponse;
import com.springbootproject.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService service;

	@GetMapping(path = "/getEmp", produces = {MediaType.APPLICATION_ATOM_XML_VALUE,MediaType.APPLICATION_JSON_VALUE })
	public EmployeeResponse getEmployee(Integer id) {
		EmployeeResponse response=new EmployeeResponse();
		EmployeeBean employeeBean=service.getEmployee(id);
		if (employeeBean!=null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Found for id :"+id);
			response.setBean(employeeBean);
		}else {
			response.setStatusCode(400);
			response.setMsg("Failure");
			response.setDescription("Data Not Found for id :"+id);
		}
			
			
		return response;
		
		
	}
	@GetMapping(path = "/getAll",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse getAll() {
		EmployeeResponse response=new EmployeeResponse();
		List<EmployeeBean>  employeeBean=service.getAllEmp();
		if (employeeBean!=null) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data Found ");
			response.setEmployeeBeans(employeeBean);
		}else {
			response.setStatusCode(400);
			response.setMsg("Failure");
			response.setDescription("Data Not Found");
		}
		return response;
		
	}
	@PostMapping(path = "/add",produces = 
		{MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},
		consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public EmployeeResponse addEmp(@RequestBody EmployeeBean employeeBean) {
		EmployeeResponse response=new EmployeeResponse();
		
		if (service.addEmployee(employeeBean)) {
			response.setStatusCode(200);
			response.setMsg("Success");
			response.setDescription("Data  Added successfully:");
			response.setBean(employeeBean);
		}else {
			response.setStatusCode(400);
			response.setMsg("Failure");
			response.setDescription("Data Already present:");
		}
			
			
		return response;
		
	}
	@DeleteMapping(path = "/delete/{emp_id}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse deleteEmp(@PathVariable(name = "emp_id")int id) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.deleteEmpData(id)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription(" Data Deleted for id : " + id);
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription(" Data not found for id : " + id);
		}
		return response;
		
	}
	
	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EmployeeResponse updateEmp(@RequestBody EmployeeBean bean) {
		EmployeeResponse response = new EmployeeResponse();
		if (service.updateEmployee(bean)) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setDescription("Updated Successfully Successfully");
		} else {
			response.setStatusCode(400);
			response.setMsg("failure");
			response.setDescription("Something Went Wrong");
		}
		return response;
		
	}

}
