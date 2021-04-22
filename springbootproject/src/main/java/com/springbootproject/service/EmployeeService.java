package com.springbootproject.service;

import java.util.List;

import com.springbootproject.dto.EmployeeBean;

public interface EmployeeService {

	public EmployeeBean getEmployee(int id);

	public boolean deleteEmpData(int id);

	public List<EmployeeBean> getAllEmp();

	public boolean addEmployee(EmployeeBean bean);

	public boolean updateEmployee(EmployeeBean bean);
}
