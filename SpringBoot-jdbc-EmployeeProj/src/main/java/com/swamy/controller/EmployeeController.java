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
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/register")
	public String showEmpRegPage(Model model) {
		model.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee ,Model model) {
		
		service.saveEmployee(employee);
		String message = "Employee Data Saved Successfully";
		model.addAttribute("message", message);
		model.addAttribute("employee", new Employee());
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	
	@GetMapping("/all")
	public String getAllEmployees(Model model) {
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmployeeById(@PathVariable Integer id ,Model model) {
		service.deleteEmployee(id);
		String message = "Employee Data '"+id+"' Deleted Successfully..!";
		model.addAttribute("message", message);
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmployeeById(@PathVariable Integer id ,Model model) {
		Employee employee = service.getOneEmployee(id);
		model.addAttribute("employee", employee);
		return "EmployeeEdit";
	}
	
	@GetMapping("/view/{id}")
	public String viewEmployeeById(@PathVariable Integer id ,Model model) {
		Employee employee = service.getOneEmployee(id);
		model.addAttribute("ob", employee);
		return "EmployeeView";
	}
	
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee ,Model model) {
		
		service.updateEmployee(employee);
		String message = "Employee Data '"+employee.getId()+"' Updated Successfully";
		model.addAttribute("message", message);
		model.addAttribute("employee", new Employee());
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
}










