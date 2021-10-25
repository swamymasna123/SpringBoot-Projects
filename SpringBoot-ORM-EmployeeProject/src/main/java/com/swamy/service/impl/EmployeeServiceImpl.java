package com.swamy.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.swamy.dao.IEmployeeDao;
import com.swamy.model.Employee;
import com.swamy.service.IEmployeeService;
import com.swamy.util.CalculateUtil;

@Service  //("empService")
@Transactional
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;

	@Autowired
	private CalculateUtil util;
	
	@Override
	public Integer saveEmployee(Employee employee) {
		util.calculateDataDynamically(employee);
		
		return dao.saveEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
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
	public void updateEmployee(Employee employee) {
		util.calculateDataDynamically(employee);
		dao.updateEmployee(employee);
	}
}

