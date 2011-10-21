/**
 * WsTransformador.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package memoria.ws;

public interface WsTransformador extends java.rmi.Remote {
    public java.lang.String getData(java.lang.String params) throws java.rmi.RemoteException;
    public java.lang.String getDataFiltro(java.lang.String capa, java.lang.Double latSurOesteVisor, java.lang.Double lonSurOesteVisor, java.lang.Double latNorEsteVisor, java.lang.Double lonNorEsteVisor) throws java.rmi.RemoteException;
}
