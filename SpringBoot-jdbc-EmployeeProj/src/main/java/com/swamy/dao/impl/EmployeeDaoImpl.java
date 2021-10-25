package com.swamy.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.swamy.dao.IEmployeeDao;
import com.swamy.map.row.EmployeeRowMapper;
import com.swamy.model.Employee;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao {

													
	private static final String SAVE_EMPLOYEE_SQL = "INSERT INTO EMPLOYEE(ENAME,ESAL) VALUES(?,?)";
	private static final String UPDATE_EMPLOYEE_SQL = "UPDATE EMPLOYEE SET ENAME=?,ESAL=? WHERE EID=?";
	private static final String DELETE_EMPLOYEE_BY_ID_SQL = "DELETE FROM EMPLOYEE WHERE EID=?";
	private static final String GET_ONE_EMPLOYEE_BY_ID_SQL = "SELECT * FROM EMPLOYEE WHERE EID=?";
	private static final String GET_ALL_EMPLOYEES_SQL = "SELECT * FROM EMPLOYEE ";
	
	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public void saveEmployee(Employee employee) {
	
		jt.update(SAVE_EMPLOYEE_SQL, employee.getEmpName(),employee.getEmpSal());
	}

	@Override
	public void updateEmployee(Employee employee) {
		jt.update(UPDATE_EMPLOYEE_SQL, employee.getEmpName(),employee.getEmpSal(),employee.getId());
	}

	@Override
	public void deleteEmployee(Integer id) {
		jt.update(DELETE_EMPLOYEE_BY_ID_SQL, id);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		return jt.queryForObject(GET_ONE_EMPLOYEE_BY_ID_SQL, new Object[] {id},
				new EmployeeRowMapper());
	}

	@Override
	public List<Employee> getAllEmployees() {
		List<Employee>list = null;
//		RowMapper<Employee>rowMapper = new EmployeeRowMapper();
//		list = jt.query(GET_ALL_EMPLOYEES_SQL, rowMapper);
		
		list = jt.query(GET_ALL_EMPLOYEES_SQL, new EmployeeRowMapper());
		return list;
	}

}

