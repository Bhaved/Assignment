package com.paypal.bfs.test.employeeserv.service;

import com.paypal.bfs.test.employeeserv.persistence.AddressEntity;
import com.paypal.bfs.test.employeeserv.persistence.EmployeeEntity;
import com.paypal.bfs.test.employeeserv.pojo.Address;
import com.paypal.bfs.test.employeeserv.pojo.Employee;

public class EmployeeUtils {

	
	public static EmployeeEntity mapToEmployeeBean(Employee employee) {
		EmployeeEntity employeeEntity = new EmployeeEntity();
		employeeEntity.setFirstName(employee.getFirstName());
		employeeEntity.setLastName(employee.getLastName());
		employeeEntity.setDateOfBirth(employee.getDateOfBirth());
		AddressEntity addressEntity = new AddressEntity();
		addressEntity.setCity(employee.getAddress().getCity());
		addressEntity.setLine1(employee.getAddress().getLine1());
		addressEntity.setLine2(employee.getAddress().getLine2());
		addressEntity.setCountry(employee.getAddress().getCountry());
		addressEntity.setZipCode(employee.getAddress().getZipCode());
		addressEntity.setState(employee.getAddress().getState());
		addressEntity.setCity(employee.getAddress().getCity());
		employeeEntity.setAddress(addressEntity);		
		return employeeEntity;
	}

	public static Employee mapEmployeeObject(EmployeeEntity employeeEntity) {
		Employee employee = new Employee();
		Address address = new Address();
		employee.setId(employeeEntity.getId());
		employee.setFirstName(employeeEntity.getFirstName());
		employee.setLastName(employeeEntity.getLastName());
		employee.setDateOfBirth(employeeEntity.getDateOfBirth());
		employee.setAddress(address);
		address.setLine1(employeeEntity.getAddress().getLine1());
		address.setLine2(employeeEntity.getAddress().getLine2());
		address.setCity(employeeEntity.getAddress().getCity());
		address.setState(employeeEntity.getAddress().getState());
		address.setCountry(employeeEntity.getAddress().getCountry());
		address.setZipCode(employeeEntity.getAddress().getZipCode());		

		return employee;
	}

}
