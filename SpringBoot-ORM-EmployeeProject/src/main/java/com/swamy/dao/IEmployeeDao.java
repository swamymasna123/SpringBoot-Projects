package com.swamy.dao;

import java.util.List;

import com.swamy.model.Employee;

public interface IEmployeeDao {

	public Integer saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public void deleteEmployee(Integer id);
	public Employee getOneEmployee(Integer id);
	public void updateEmployee(Employee employee);
}
