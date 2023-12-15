package com.employee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.employee.entity.Employee;
import com.employee.repository.EmployeeRepository;

@Service
public class EmployeeServiceImp implements EmployeeService
{
	@Autowired
	private EmployeeRepository employeerepository;

	public Employee addEmployee(Employee employee) {
		
		return employeerepository.save(employee);
	}

	public Employee updateEmployee(Employee employee,int id) {
		
		Employee emp = employeerepository.findById(id).get();
		emp.setName(employee.getName());
		emp.setDept(employee.getDept());
		emp.setEmpid(employee.getEmpid());
		emp.setRole(employee.getRole());
		
		Employee update_data = employeerepository.save(emp);
		return update_data;
	}

	public String deleteEmployee(int id) 
	{
		employeerepository.deleteById(id);
		return String.format(" %d id emplyee deleted succefully..",id);
	}

	
	public Employee getEmployee(int id) {
		
		return employeerepository.findById(id).get();
	}

	public List<Employee> getEmployeeList(Employee employee) 
	{
			
		return employeerepository.findAll();
	}
	
	public Employee updateEmployee_wot_id(Employee employee)
	{
		return employeerepository.save(employee);
	}

	
}
