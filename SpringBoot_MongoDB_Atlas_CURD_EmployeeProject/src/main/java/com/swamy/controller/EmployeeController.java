package com.swamy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.swamy.model.Employee;
import com.swamy.service.IEmployeeService;

@Controller
@RequestMapping("/emp-api")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	//FETCH EMPLOYESS LIST DATA 
	@GetMapping("/all")
	public String showEmployeesListData(Model model) {
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeesDataPage";
	}

	@GetMapping("/register")
	public String showEmpRegPage(Model model) {
		//Form Backing Object
		model.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}

	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee ,Model model) {
		String data = service.saveEmployee(employee);
		String message = "Employee Data '"+data+"' Saved Successfully..!";
		model.addAttribute("message",message);
		//Form Backing Object
		model.addAttribute("employee", new Employee());
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeesDataPage";
	}

	//DELETE EMPLOYEE OPERATION
	@GetMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable String id,Model model) {
		service.deleteEmployee(id);
		String message = "Employee Data '"+id+"' Deleted Successfully..!";
		model.addAttribute("message", message);
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeesDataPage";
	}

	//EDIT EMPLOYEE OPERATION
	@GetMapping("/edit/{id}")
	public String editEmployeeById(@PathVariable String id,Model model) {
		Employee employee = service.getOneEmployee(id);
		model.addAttribute("employee", employee);
		return "EmployeeEditPage";
	}

	//Update Operation
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee ,Model model) {
		service.updateEmployee(employee);
		String message = "Employee Data '"+employee.getId()+"' Updated Successfully..!";
		model.addAttribute("message",message);
		//Form Backing Object
		model.addAttribute("employee", new Employee());
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeesDataPage";
	}

	//VIEW EMPLOYEE OPERATION
	@GetMapping("/view/{id}")
	public String viewEmployeeById(@PathVariable String id,Model model) {
		Employee employee = service.getOneEmployee(id);
		model.addAttribute("ob", employee);
		return "EmployeeViewPage";
	}
}


