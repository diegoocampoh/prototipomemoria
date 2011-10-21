package memoria.ws;

public class WsTransformadorProxy implements memoria.ws.WsTransformador {
  private String _endpoint = null;
  private memoria.ws.WsTransformador wsTransformador = null;
  
  public WsTransformadorProxy() {
    _initWsTransformadorProxy();
  }
  
  public WsTransformadorProxy(String endpoint) {
    _endpoint = endpoint;
    _initWsTransformadorProxy();
  }
  
  private void _initWsTransformadorProxy() {
    try {
      wsTransformador = (new memoria.ws.WsTransformadorServiceLocator()).getwsTransformadorPort();
      if (wsTransformador != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)wsTransformador)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)wsTransformador)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (wsTransformador != null)
      ((javax.xml.rpc.Stub)wsTransformador)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public memoria.ws.WsTransformador getWsTransformador() {
    if (wsTransformador == null)
      _initWsTransformadorProxy();
    return wsTransformador;
  }
  
  public java.lang.String getData(java.lang.String params) throws java.rmi.RemoteException{
    if (wsTransformador == null)
      _initWsTransformadorProxy();
    return wsTransformador.getData(params);
  }
  
  public java.lang.String getDataFiltro(java.lang.String capa, java.lang.Double latSurOesteVisor, java.lang.Double lonSurOesteVisor, java.lang.Double latNorEsteVisor, java.lang.Double lonNorEsteVisor) throws java.rmi.RemoteException{
    if (wsTransformador == null)
      _initWsTransformadorProxy();
    return wsTransformador.getDataFiltro(capa, latSurOesteVisor, lonSurOesteVisor, latNorEsteVisor, lonNorEsteVisor);
  }
  
  
}