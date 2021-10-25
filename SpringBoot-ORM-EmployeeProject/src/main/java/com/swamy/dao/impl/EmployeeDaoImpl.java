package com.swamy.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.swamy.dao.IEmployeeDao;
import com.swamy.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private HibernateTemplate ht; 
	
	@Override
	public Integer saveEmployee(Employee employee) {
		return (Integer)ht.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return ht.loadAll(Employee.class);
	}

	@Override
	public void deleteEmployee(Integer id) {
		Employee emp = new Employee();
		emp.setId(id);
		ht.delete(emp);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		return ht.get(Employee.class, id);
	}

	@Override
	public void updateEmployee(Employee employee) {
		ht.update(employee);
	}

}

