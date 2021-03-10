package com.paypal.bfs.test.employeeserv.service;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.exception.EmployeeException;
import com.paypal.bfs.test.employeeserv.pojo.Employee;

@Service
public interface EmployeeService {
	
	
	public Employee employeeGetById(@Valid Integer id) throws EmployeeException;
	
	public Integer createEmployee(@Valid Employee employee);

}
