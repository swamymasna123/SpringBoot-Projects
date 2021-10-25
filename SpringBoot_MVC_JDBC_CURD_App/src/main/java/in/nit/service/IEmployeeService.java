package in.nit.service;

import java.util.List;

import in.nit.model.Employee;

public interface IEmployeeService {

	public Integer saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Integer deleteEmployee(Integer id);
	public Integer updateEmployee(Employee employee);
	public Employee getOneEmployee(Integer id);

}
