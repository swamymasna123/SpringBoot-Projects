package in.nit.dao;

import java.util.List;

import in.nit.model.Employee;

public interface IEmployeeDao {

	public Integer saveEmployee(Employee employee);
	public List<Employee> getAllEmployees();
	public Integer deleteEmployee(Integer id);
	public Integer updateEmployee(Employee employee);
	public Employee getOneEmployee(Integer id);
}
