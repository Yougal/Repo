package com.yougal;

import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import com.yougal.ws.Employee;
import com.yougal.ws.EmployeeManagementServiceImpl;
import com.yougal.ws.EmployeeManagementServiceImplServiceLocator;

public class EmployeeServiceClient {

	public static void main(String[] args) throws ServiceException, RemoteException {
		EmployeeManagementServiceImpl employeeManagementServiceImplPort = new EmployeeManagementServiceImplServiceLocator().getEmployeeManagementServiceImplPort();
		Employee employeeById = employeeManagementServiceImplPort.getEmployeeById(1);
		System.out.println(employeeById.getName());
	}
	
}
