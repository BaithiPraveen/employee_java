package com.employee.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.employee.entity.Employee;
//import com.employee.service.EmployeeService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employee.entity.Employee;
import com.employee.service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeController 
{
	@Autowired
	EmployeeService emp_ser;
	
	
	@GetMapping("/")
	public List<Employee> findAllEmployees()
	{
		Employee emp_obj = new Employee();		
		
		return  emp_ser.getEmployeeList(emp_obj);
	}
	
	@PostMapping("/")
	public Employee save_data(@RequestBody Employee emp)
	{
		return emp_ser.addEmployee(emp);
	}
	
	@PutMapping("/")
	public Employee update_data(@RequestBody Employee emp)
	{
		return emp_ser.updateEmployee_wot_id(emp);
	}
	
	@GetMapping("/{id}")
	public Employee get_employee(@PathVariable("id") int id)
	{
		return emp_ser.getEmployee(id);
	}
	
	@DeleteMapping("/{id}")
	public String delete_employee(@PathVariable("id") int id)
	{
		return emp_ser.deleteEmployee(id);
	}
	
	@PatchMapping("/{id}")
	public Employee patch_data(@PathVariable("id")int id,@RequestBody Employee employee)
	{
		Employee emp = emp_ser.getEmployee(id);
		
		String empid = employee.getEmpid();
		String name = employee.getName();
		String role  = employee.getRole();
		String dept = employee.getDept();
		
		if (empid != null)
			emp.setEmpid(empid);
		if (dept != null)
			emp.setDept(dept);
		if (role != null)
			emp.setRole(role);
		if (name != null)
			emp.setName(name);
		
		Employee patch_employee = emp_ser.updateEmployee_wot_id(emp);
		
		return patch_employee;
	}
	
	
	
	
	
	
	
//	@Autowired
//	EmployeeService employee_service;
//	
//	@GetMapping("/insert/")
//	public String insertData() 
//	{
//		Employee emp = new Employee();
//		
//		emp.setName("ram");
//		emp.setDept("java");
//		emp.setEmpid("NS3355");
//		emp.setRole("dev");
//		
//		Employee emp_det= employee_service.addEmployee(emp);
//		
//		System.out.println("emp data : "+emp_det);
//		
//		return String.format("employee is created %S ", emp_det.getName());
//	}
//	
//	@GetMapping("/get_det/")
//	public List<Employee> getdata()
//	{
//		Employee emp = new Employee();
//		return employee_service.getEmployeeList(emp);
//	}
//	
//	@GetMapping("/get_det/{id}")
//	public Employee get_one_data(@PathVariable(name = "id") int id)
//	{		
//		Employee emp =employee_service.getEmployee(id);
//		System.out.println("emp_det : "+emp);
//		return emp;
//	}
//	
//	@PostMapping("/create/")
//	public ResponseEntity<String> postmaping(@RequestBody Employee emp)
//	{
//		Employee emp_det =employee_service.addEmployee(emp);		
//        return new ResponseEntity<String>("Employee is created: " + emp_det.getName(), HttpStatus.CREATED);
//	}
//	
//	
//	@DeleteMapping("/delete/{id}")
//	public String  delete_record(@PathVariable(name = "id") int id)
//	{
//		String msg = employee_service.deleteEmployee(id);
//		
//		return msg;
//	}
//	
//	@PutMapping("/update/{id}")
//	public Employee update(@PathVariable(name = "id") int id,@RequestBody Employee emp)
//	{
//		Employee emp_det = employee_service.updateEmployee(emp,id);
//		return emp_det;
//	}
//	
	

}
