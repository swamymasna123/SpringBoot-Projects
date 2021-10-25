package com.swamy.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.model.Employee;
import com.swamy.service.IEmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeRestController {

	@Autowired
	private IEmployeeService service;
	
	//FETCH EMPLOYEE DATA FROM ATLAS-MONGODB DATABASE
	@GetMapping
	public ResponseEntity<?>getAllEmployeesData(){
		ResponseEntity<?>resp = null;
		try {
			List<Employee> list = service.getAllEmployees();
			if(list!=null) {
				resp = ResponseEntity.ok(list);
			}
			else {
				resp = new ResponseEntity<String>("EMPLOYEE DATA NOT FOUND TO FECTH",HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			resp = new ResponseEntity<String>("UNABLE TO FECTH EMPLOYEE DATA",HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
}



