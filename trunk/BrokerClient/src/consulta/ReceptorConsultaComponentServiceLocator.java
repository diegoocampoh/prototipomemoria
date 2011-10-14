/**
 * ReceptorConsultaComponentServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package consulta;

public class ReceptorConsultaComponentServiceLocator extends org.apache.axis.client.Service implements consulta.ReceptorConsultaComponentService {

    public ReceptorConsultaComponentServiceLocator() {
    }


    public ReceptorConsultaComponentServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ReceptorConsultaComponentServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for ReceptorConsultaComponentPort
    private java.lang.String ReceptorConsultaComponentPort_address = "http://flor-pc:8085/ReceptorConsultaService";

    public java.lang.String getReceptorConsultaComponentPortAddress() {
        return ReceptorConsultaComponentPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String ReceptorConsultaComponentPortWSDDServiceName = "ReceptorConsultaComponentPort";

    public java.lang.String getReceptorConsultaComponentPortWSDDServiceName() {
        return ReceptorConsultaComponentPortWSDDServiceName;
    }

    public void setReceptorConsultaComponentPortWSDDServiceName(java.lang.String name) {
        ReceptorConsultaComponentPortWSDDServiceName = name;
    }

    public consulta.ReceptorConsultaComponent getReceptorConsultaComponentPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(ReceptorConsultaComponentPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getReceptorConsultaComponentPort(endpoint);
    }

    public consulta.ReceptorConsultaComponent getReceptorConsultaComponentPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            consulta.ReceptorConsultaComponentBindingStub _stub = new consulta.ReceptorConsultaComponentBindingStub(portAddress, this);
            _stub.setPortName(getReceptorConsultaComponentPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setReceptorConsultaComponentPortEndpointAddress(java.lang.String address) {
        ReceptorConsultaComponentPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (consulta.ReceptorConsultaComponent.class.isAssignableFrom(serviceEndpointInterface)) {
                consulta.ReceptorConsultaComponentBindingStub _stub = new consulta.ReceptorConsultaComponentBindingStub(new java.net.URL(ReceptorConsultaComponentPort_address), this);
                _stub.setPortName(getReceptorConsultaComponentPortWSDDServiceName());
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
        if ("ReceptorConsultaComponentPort".equals(inputPortName)) {
            return getReceptorConsultaComponentPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://modulos.geoConsulta.broker/", "ReceptorConsultaComponentService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://modulos.geoConsulta.broker/", "ReceptorConsultaComponentPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("ReceptorConsultaComponentPort".equals(portName)) {
            setReceptorConsultaComponentPortEndpointAddress(address);
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
