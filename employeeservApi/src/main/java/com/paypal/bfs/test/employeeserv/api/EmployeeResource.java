package com.paypal.bfs.test.employeeserv.api;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.paypal.bfs.test.employeeserv.pojo.Employee;

/**
 * Interface for employee resource operations.
 */

public interface EmployeeResource {

    /**
     * Retrieves the {@link Employee} resource by id.
     *
     * @param id employee id.
     * @return {@link Employee} resource.
     * @throws Exception 
     */
    @RequestMapping("/v1/bfs/employees/{id}")
    ResponseEntity<Employee> employeeGetById( @PathVariable("id") Integer id) throws Exception;

    @RequestMapping("/v1/bfs/employees/")
    Integer createEmployee(@Valid @RequestBody Employee employee);

}
