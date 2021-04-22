package com.springbootproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springbootproject.dao.EmployeeDAO;
import com.springbootproject.dto.EmployeeBean;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDAO dao;

	@Override
	public EmployeeBean getEmployee(int id) {

		return dao.getEmployee(id);
	}

	@Override
	public boolean deleteEmpData(int id) {

		return dao.deleteEmpData(id);
	}

	@Override
	public List<EmployeeBean> getAllEmp() {

		return dao.getAllEmp();
	}

	@Override
	public boolean addEmployee(EmployeeBean bean) {

		return dao.addEmployee(bean);
	}

	@Override
	public boolean updateEmployee(EmployeeBean bean) {

		return dao.updateEmployee(bean);
	}

}
