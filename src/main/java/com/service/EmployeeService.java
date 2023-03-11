package com.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.model.Employee;

@Component
public class EmployeeService {
	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Transactional
	public void addEmployee(Employee employee) {
		this.hibernateTemplate.saveOrUpdate(employee);
	}

	public List<Employee> getEmployees() {
		List<Employee> employees = this.hibernateTemplate.loadAll(Employee.class);
		return employees;
	}

	@Transactional
	public void deleteEmployee(int id) {
		Employee employee = this.hibernateTemplate.load(Employee.class, id);
		this.hibernateTemplate.delete(employee);
	}

	public Employee getEmployee(int id) {
		return this.hibernateTemplate.get(Employee.class, id);
	}

}
