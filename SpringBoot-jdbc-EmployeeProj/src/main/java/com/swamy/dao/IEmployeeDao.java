package com.swamy.dao;

import java.util.List;

import com.swamy.model.Employee;

public interface IEmployeeDao {

	public void saveEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public void deleteEmployee(Integer id);
	public Employee getOneEmployee(Integer id);
	public List<Employee> getAllEmployees();
}
