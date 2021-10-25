package in.nit.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import in.nit.model.Employee;

public class EmployeeRowMapper implements RowMapper<Employee> {

	@Override
	public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
		//create the model class object
		Employee employee = new Employee();
		employee.setEid(rs.getInt("eid"));
		employee.setEname(rs.getString("ename"));
		employee.setEsal(rs.getDouble("esal"));
		return employee;
	}
}




