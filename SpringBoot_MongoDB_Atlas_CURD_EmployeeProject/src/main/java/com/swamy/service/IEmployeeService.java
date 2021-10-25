package com.swamy.service;

import java.util.List;

import com.swamy.model.Employee;

public interface IEmployeeService {

	public List<Employee>getAllEmployees();
	public String saveEmployee(Employee employee);
	public void deleteEmployee(String id);
	public Employee getOneEmployee(String id);
	public void updateEmployee(Employee employee);
}

