package in.nit.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import in.nit.dao.IEmployeeDao;
import in.nit.mapper.EmployeeRowMapper;
import in.nit.model.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements IEmployeeDao {

	@Autowired
	private JdbcTemplate jt;
	
	@Override
	public Integer saveEmployee(Employee employee) {
		String sql = "INSERT INTO EMPLOYEE(EID,ENAME,ESAL) VALUES(?,?,?)";
		return jt.update(sql, employee.getEid(),employee.getEname(),employee.getEsal());
	}

	@Override
	public List<Employee> getAllEmployees() {
		//create RowMapper obejct
		String sql = "SELECT * FROM EMPLOYEE";
		RowMapper<Employee>rowMapper = new EmployeeRowMapper();
		List<Employee>list = jt.query(sql, rowMapper);
		return list;
	}

	@Override
	public Integer deleteEmployee(Integer id) {
		String sql = "DELETE FROM EMPLOYEE WHERE EID=?";
		return jt.update(sql, id);
	}

	@Override
	public Employee getOneEmployee(Integer id) {
		String sql = "SELECT * FROM EMPLOYEE WHERE EID=?";
		return jt.queryForObject(sql, 
				new Object[] {id}, 
				new BeanPropertyRowMapper<Employee>(Employee.class));
	}

	@Override
	public Integer updateEmployee(Employee employee) {
		String sql = "UPDATE EMPLOYEE SET ENAME=?,ESAL=? WHERE EID=?";
		return jt.update(sql, employee.getEname(),employee.getEsal(),employee.getEid());
	}
	
	
}






