package in.nit.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.nit.dao.IEmployeeDao;
import in.nit.model.Employee;
import in.nit.service.IEmployeeService;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

	@Autowired
	private IEmployeeDao dao;
	
	@Override
	public Integer saveEmployee(Employee employee) {
		return dao.saveEmployee(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dao.getAllEmployees();
	}

	@Override
	public Integer deleteEmployee(Integer id) {
		return dao.deleteEmployee(id);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		return dao.getOneEmployee(id);
	}

	@Override
	public Integer updateEmployee(Employee employee) {
		return dao.updateEmployee(employee);
	}


}
