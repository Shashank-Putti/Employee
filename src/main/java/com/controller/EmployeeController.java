package com.controller;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.model.Employee;
import com.service.EmployeeService;

@Controller
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;

	@RequestMapping("/")
	public String home(Model model) {
		List<Employee> employees = employeeService.getEmployees();
		model.addAttribute("employees", employees);
		return "index";
	}

	@RequestMapping("/add-Employee")
	public String addEmployee(Model model, @RequestParam(required = false) String dob) {
		model.addAttribute("title", "Add Employee");
		if (dob != null) {
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(dob, dateTimeFormatter);
			model.addAttribute("dob", date);
			Employee employee = new Employee();
			employee.setDob("date");
			model.addAttribute("employee", employee);
		} else {
			model.addAttribute("employee", new Employee());
		}

		return "addEmployeeForm";
	}

	@RequestMapping(value = "/handle-employee", method = RequestMethod.POST)
	public RedirectView handleEmplyoee(@ModelAttribute Employee employee, HttpServletRequest request) {
		LocalDate dob = employee.getDob();
		LocalDate now = LocalDate.now();
		int age = Period.between(dob, now).getYears();
		employee.setAge(age);
		this.employeeService.addEmployee(employee);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping("/delete/{employeeId}")
	public RedirectView deleteEmplyoee(@PathVariable("employeeId") int employeeId, HttpServletRequest request) {
		this.employeeService.deleteEmployee(employeeId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;
	}

	@RequestMapping("/update/{employeeId}")
	public String updateEmployee(@PathVariable("employeeId") int employeeId, Model model) {
		Employee employee = this.employeeService.getEmployee(employeeId);
		model.addAttribute("employee", employee);
		return "updateEmployee";
	}

}
