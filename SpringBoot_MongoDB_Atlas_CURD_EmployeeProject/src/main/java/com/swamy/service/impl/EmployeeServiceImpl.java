package com.swamy.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.swamy.model.Employee;
import com.swamy.repo.EmployeeRepository;
import com.swamy.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private EmployeeRepository repo;
	
	@Override
	public List<Employee> getAllEmployees() {
		List<Employee> list = null;
		list = repo.findAll();
		return list;
	}

	@Override
	public String saveEmployee(Employee employee) {
		String data = null;
		data = repo.save(employee).getId();
		return data;
	}

	@Override
	public void deleteEmployee(String id) {
		repo.deleteById(id);
	}

	@Override
	public Employee getOneEmployee(String id) {
		Employee employee = null;
		Optional<Employee> opt = repo.findById(id);
		if(opt.isPresent()) {
			employee = opt.get();
		}
		else {
			throw new RuntimeException("Employee Not Found to Fetch..!");
		}
		return employee;
	}

	@Override
	public void updateEmployee(Employee employee) {
		repo.save(employee);
	}

}

