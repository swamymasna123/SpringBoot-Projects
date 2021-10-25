package com.swamy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swamy.dao.IEmployeeDao;
import com.swamy.model.Employee;
import com.swamy.service.IEmployeeService;

@Service
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public void saveEmployee(Employee employee) {
		dao.saveEmployee(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		dao.updateEmployee(employee);
	}

	@Override
	public void deleteEmployee(Integer id) {
		dao.deleteEmployee(id);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		return dao.getOneEmployee(id);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

}

