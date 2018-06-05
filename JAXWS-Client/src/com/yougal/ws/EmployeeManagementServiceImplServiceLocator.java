/**
 * EmployeeManagementServiceImplServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.yougal.ws;

public class EmployeeManagementServiceImplServiceLocator extends org.apache.axis.client.Service implements com.yougal.ws.EmployeeManagementServiceImplService {

    public EmployeeManagementServiceImplServiceLocator() {
    }


    public EmployeeManagementServiceImplServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public EmployeeManagementServiceImplServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for EmployeeManagementServiceImplPort
    private java.lang.String EmployeeManagementServiceImplPort_address = "http://localhost:8080/JAXWS-Service/employee";

    public java.lang.String getEmployeeManagementServiceImplPortAddress() {
        return EmployeeManagementServiceImplPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String EmployeeManagementServiceImplPortWSDDServiceName = "EmployeeManagementServiceImplPort";

    public java.lang.String getEmployeeManagementServiceImplPortWSDDServiceName() {
        return EmployeeManagementServiceImplPortWSDDServiceName;
    }

    public void setEmployeeManagementServiceImplPortWSDDServiceName(java.lang.String name) {
        EmployeeManagementServiceImplPortWSDDServiceName = name;
    }

    public com.yougal.ws.EmployeeManagementServiceImpl getEmployeeManagementServiceImplPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(EmployeeManagementServiceImplPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getEmployeeManagementServiceImplPort(endpoint);
    }

    public com.yougal.ws.EmployeeManagementServiceImpl getEmployeeManagementServiceImplPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.yougal.ws.EmployeeManagementServiceImplPortBindingStub _stub = new com.yougal.ws.EmployeeManagementServiceImplPortBindingStub(portAddress, this);
            _stub.setPortName(getEmployeeManagementServiceImplPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setEmployeeManagementServiceImplPortEndpointAddress(java.lang.String address) {
        EmployeeManagementServiceImplPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.yougal.ws.EmployeeManagementServiceImpl.class.isAssignableFrom(serviceEndpointInterface)) {
                com.yougal.ws.EmployeeManagementServiceImplPortBindingStub _stub = new com.yougal.ws.EmployeeManagementServiceImplPortBindingStub(new java.net.URL(EmployeeManagementServiceImplPort_address), this);
                _stub.setPortName(getEmployeeManagementServiceImplPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("EmployeeManagementServiceImplPort".equals(inputPortName)) {
            return getEmployeeManagementServiceImplPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://ws.yougal.com/", "EmployeeManagementServiceImplService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://ws.yougal.com/", "EmployeeManagementServiceImplPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("EmployeeManagementServiceImplPort".equals(portName)) {
            setEmployeeManagementServiceImplPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
