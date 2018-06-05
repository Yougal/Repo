package com.yougal.ws;

public class EmployeeManagementServiceImplProxy implements com.yougal.ws.EmployeeManagementServiceImpl {
  private String _endpoint = null;
  private com.yougal.ws.EmployeeManagementServiceImpl employeeManagementServiceImpl = null;
  
  public EmployeeManagementServiceImplProxy() {
    _initEmployeeManagementServiceImplProxy();
  }
  
  public EmployeeManagementServiceImplProxy(String endpoint) {
    _endpoint = endpoint;
    _initEmployeeManagementServiceImplProxy();
  }
  
  private void _initEmployeeManagementServiceImplProxy() {
    try {
      employeeManagementServiceImpl = (new com.yougal.ws.EmployeeManagementServiceImplServiceLocator()).getEmployeeManagementServiceImplPort();
      if (employeeManagementServiceImpl != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)employeeManagementServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)employeeManagementServiceImpl)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (employeeManagementServiceImpl != null)
      ((javax.xml.rpc.Stub)employeeManagementServiceImpl)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.yougal.ws.EmployeeManagementServiceImpl getEmployeeManagementServiceImpl() {
    if (employeeManagementServiceImpl == null)
      _initEmployeeManagementServiceImplProxy();
    return employeeManagementServiceImpl;
  }
  
  public com.yougal.ws.Employee getEmployeeById(java.lang.Integer arg0) throws java.rmi.RemoteException{
    if (employeeManagementServiceImpl == null)
      _initEmployeeManagementServiceImplProxy();
    return employeeManagementServiceImpl.getEmployeeById(arg0);
  }
  
  
}