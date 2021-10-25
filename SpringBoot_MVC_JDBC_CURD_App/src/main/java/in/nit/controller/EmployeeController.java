package in.nit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.nit.model.Employee;
import in.nit.service.IEmployeeService;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;

	@GetMapping("/register")
	public String showPage() {
		return "Register";
	}

	@RequestMapping("/save")
	public String saveEmployee(@ModelAttribute("employee")Employee employee,Model model ) {
		Integer id = service.saveEmployee(employee);
		String message = "Employee '"+id+"' Data Saved Successfully...!";
		model.addAttribute("message", message);
		return "Register";
	}

	@GetMapping("/all")
	public String getAllEmployees(Model model) {
		List<Employee>list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "Data";
	}


	@RequestMapping("/delete")
	public String deleteEmployee(@RequestParam("id")Integer id,Model model) {
		Integer data = service.deleteEmployee(id);
		String message = "Employee '"+data+"' Data Deleted Successfully..!";
		model.addAttribute("message", message);
		List<Employee>list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "Data";
	}

	@GetMapping("/edit")
	public String getOneEmployee(@RequestParam("id")Integer id,Model model) {
		Employee employee = service.getOneEmployee(id);
		model.addAttribute("ob", employee);
		return "Edit";
	}

	@RequestMapping("/update")
	public String updateEmployee(@ModelAttribute("employee")Employee employee,Model model) {
		Integer id = service.updateEmployee(employee);
		String message = "Employee '"+employee.getEid()+"' Updated Successfully...!";
		model.addAttribute("message", message);
		List<Employee>list = service.getAllEmployees();
		model.addAttribute("list", list);
		return "Data";
	}

}











