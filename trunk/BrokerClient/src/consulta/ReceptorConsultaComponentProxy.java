package consulta;

public class ReceptorConsultaComponentProxy implements consulta.ReceptorConsultaComponent {
  private String _endpoint = null;
  private consulta.ReceptorConsultaComponent receptorConsultaComponent = null;
  
  public ReceptorConsultaComponentProxy() {
    _initReceptorConsultaComponentProxy();
  }
  
  public ReceptorConsultaComponentProxy(String endpoint) {
    _endpoint = endpoint;
    _initReceptorConsultaComponentProxy();
  }
  
  private void _initReceptorConsultaComponentProxy() {
    try {
      receptorConsultaComponent = (new consulta.ReceptorConsultaComponentServiceLocator()).getReceptorConsultaComponentPort();
      if (receptorConsultaComponent != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)receptorConsultaComponent)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)receptorConsultaComponent)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (receptorConsultaComponent != null)
      ((javax.xml.rpc.Stub)receptorConsultaComponent)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public consulta.ReceptorConsultaComponent getReceptorConsultaComponent() {
    if (receptorConsultaComponent == null)
      _initReceptorConsultaComponentProxy();
    return receptorConsultaComponent;
  }
  
  public java.lang.String obtenerGeoInfo(java.lang.String arg0) throws java.rmi.RemoteException{
    if (receptorConsultaComponent == null)
      _initReceptorConsultaComponentProxy();
    return receptorConsultaComponent.obtenerGeoInfo(arg0);
  }
  
  
}