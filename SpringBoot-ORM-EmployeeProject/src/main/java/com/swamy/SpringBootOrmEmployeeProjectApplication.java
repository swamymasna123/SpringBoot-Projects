package com.swamy;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.swamy.dao.IEmployeeDao;
import com.swamy.model.Employee;
import com.swamy.service.IEmployeeService;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class SpringBootOrmEmployeeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootOrmEmployeeProjectApplication.class,args);
		
		/*
		
		ApplicationContext ctx = null;
		IEmployeeDao dao = null;  //empDao
		IEmployeeService service = null;
		ctx = SpringApplication.run(SpringBootOrmEmployeeProjectApplication.class, args);
		service = ctx.getBean("employeeServiceImpl",IEmployeeService.class);
		System.out.println("\n--------------------------------------");
		System.out.println("SERVICE Object Has Been Created : " + service);
		System.out.println("--------------------------------------");
		
		
		//------------SAVE EMPLOYEE OPERATION------------
//		System.out.println("\n------------SAVE EMPLOYEE OPERATION------------");
//		Employee emp = new Employee();
//		emp.setEmpName("TARAK");
//		emp.setEmpSal(93000.00);
//		emp.setEmpAddress("VIZAG");
//		Integer id = service.saveEmployee(emp);
//		System.out.println("Employee Data '"+id+"' Has been Saved Successfully...!");
		
		
		//------------LIST EMPLOYEES OPERATION------------	
		List<Employee> list = service.getAllEmployees();
		System.out.println("\n------------LIST EMPLOYEES OPERATION------------");
//		list.forEach(emp->{
//			System.out.println(emp);
//		});
		
//		list.forEach(System.out::println);
//		for (Employee employee : list) {
//			System.out.println(employee);
//		}
		list.stream().forEach(System.out::println);
		
		
		
		
		//------------LIST EMPLOYEES OPERATION------------	
		Employee empObj = service.getOneEmployee(9);
		System.out.println("\n----FETCH SINGLE EMPLOYEE OPERATION-----");
		System.out.println(empObj);
		
		
		//------------UPDATE EMPLOYEE OPERATION------------	
		Employee eob = new Employee();
		eob.setId(9);
		eob.setEmpName(" KIRAN-UPDATED");
		eob.setEmpSal(71000.00);
		eob.setEmpAddress("ADILABAD");
		service.updateEmployee(eob);
		System.out.println("\nEmployee Data '"+eob.getId()+"' Has been Updated Successfully...!");
		
		
		//------------DELETE EMPLOYEE OPERATION------------	
//		service.deleteEmployee(3);
//		System.out.println("\nEmployee Data Has been Deleted Successfully...!");

	*/
		
	}
	

}
