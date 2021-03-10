package com.paypal.bfs.test.employeeserv.service;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paypal.bfs.test.employeeserv.exception.EmployeeException;
import com.paypal.bfs.test.employeeserv.persistence.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.persistence.EmployeeRepository;
import com.paypal.bfs.test.employeeserv.pojo.Employee;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	@Override
	public Employee employeeGetById(Integer id) throws EmployeeException {
		Employee employee = null;
		try {
			Optional<EmployeeEntity> result = employeeRepository.findById(id);
			EmployeeEntity employeeEntity= result.get();
			employee = EmployeeUtils.mapEmployeeObject(employeeEntity);
		}catch(NoSuchElementException nae){
			throw new EmployeeException("Employee doesn´t exist for the requested Id");
		}
		return employee;
	}

	@Override
	public Integer createEmployee(Employee employee) {
		EmployeeEntity employeeEntity = EmployeeUtils.mapToEmployeeBean(employee);
		employeeEntity = employeeRepository.save(employeeEntity);
		return employeeEntity.getId();
	}
}
