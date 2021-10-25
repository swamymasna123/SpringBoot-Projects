package com.swamy.map.row;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.swamy.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		Employee emp = new Employee();
		emp.setId(rs.getInt("eid"));
		emp.setEmpName(rs.getString("ename"));
		emp.setEmpSal(rs.getDouble("esal"));
		return emp;
	}
}
