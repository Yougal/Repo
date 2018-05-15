package com.yougal.ws;

import javax.jws.WebService;

@WebService
public class EmployeeManagementServiceImpl implements EmployeeManagementService {

	@Override
	public Employee getEmployeeById(Integer id) {
		return new Employee("Yougal Bisht", 1);
	}

}
