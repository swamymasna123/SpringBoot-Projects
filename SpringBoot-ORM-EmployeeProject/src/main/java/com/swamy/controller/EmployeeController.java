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

	//USING THYMELEAF-UI AS FRONT END/VIEW PAGES
	
	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/all")
	public String getAllEmpsData(Model model) {
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	@GetMapping("/register")
	public String showEmployeeRegPage(Model model) {
		//Form Backing Object
		model.addAttribute("employee", new Employee());
		return "EmployeeRegister";
	}
	
	@PostMapping("/save")
	public String saveEmployee(@ModelAttribute Employee employee,Model model) {

		Integer id = service.saveEmployee(employee);
		String message = "Employee Data '"+id+"' Saved Successfully";
		model.addAttribute("message", message);
		//Form Backing Object
		model.addAttribute("employee", new Employee());
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteEmpById(@PathVariable Integer id,Model model) {
		service.deleteEmployee(id);
		String message = "Employee Data '"+id+"' Has Been Deleted Successfully";
		model.addAttribute("message", message);
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	@GetMapping("/edit/{id}")
	public String editEmpById(@PathVariable Integer id,Model model) {
		Employee employee = service.getOneEmployee(id);
		model.addAttribute("employee", employee);
		return "EmployeeEdit";
	}
	
	@PostMapping("/update")
	public String updateEmployee(@ModelAttribute Employee employee,Model model) {

		service.updateEmployee(employee);
		String message = "Employee Data '"+employee.getId()+"' Updated Successfully";
		model.addAttribute("message", message);
		//Form Backing Object
		model.addAttribute("employee", new Employee());
		List<Employee> list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "EmployeeData";
	}
	
	@GetMapping("/view/{id}")
	public String viewEmpById(@PathVariable Integer id,Model model) {
		Employee employee = service.getOneEmployee(id);
		model.addAttribute("ob", employee);
		return "EmployeeView";
	}
}












