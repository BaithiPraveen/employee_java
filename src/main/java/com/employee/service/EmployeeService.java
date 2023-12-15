package com.employee.service;

import java.util.List;

import com.employee.entity.Employee;

public interface EmployeeService 
{
	public Employee addEmployee(Employee employee);
	
	public Employee updateEmployee(Employee employee,int id);
	
	public String deleteEmployee(int id);
	
	public Employee getEmployee(int id);
	
	public List<Employee> getEmployeeList(Employee employee);
	
	public Employee updateEmployee_wot_id(Employee employee);
	
	
}
