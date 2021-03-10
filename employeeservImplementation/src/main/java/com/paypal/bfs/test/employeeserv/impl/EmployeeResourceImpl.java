package com.paypal.bfs.test.employeeserv.impl;

import com.paypal.bfs.test.employeeserv.api.EmployeeResource;
import com.paypal.bfs.test.employeeserv.exception.EmployeeException;
import com.paypal.bfs.test.employeeserv.persistence.AddressEntity;
import com.paypal.bfs.test.employeeserv.persistence.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.persistence.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.pojo.Address;
import com.paypal.bfs.test.employeeserv.pojo.Employee;
import com.paypal.bfs.test.employeeserv.service.EmployeeService;

import java.util.NoSuchElementException;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

/**
 * Implementation class for employee resource.
 */
@RestController
public class EmployeeResourceImpl implements EmployeeResource {

	@Autowired
	EmployeeService employeeService;

	@Override
	public ResponseEntity<Employee> employeeGetById(Integer id) throws EmployeeException {
		Employee employee =null;
		try {
			 employee =employeeService.employeeGetById(id);
		
		}catch(NumberFormatException nae) {
			
		}
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}



	@Override
	public Integer createEmployee(Employee employee) {
		Integer empId = employeeService.createEmployee(employee);
		return empId;
	}

}
