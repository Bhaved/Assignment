package com.paypal.bfs.test.employeeserv.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository  extends CrudRepository<EmployeeEntity, Integer>  {
	
	public EmployeeEntity findByFirstName(String firstName);


}
