
package wsconsume;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2-hudson-752-
 * Generated source version: 2.2
 * 
 */
@WebService(name = "wsTransformador", targetNamespace = "http://ws.memoria/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface WsTransformador {


    /**
     * 
     * @param latSurOesteVisor
     * @param latNorEsteVisor
     * @param capa
     * @param lonSurOesteVisor
     * @param lonNorEsteVisor
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getDataFiltro", targetNamespace = "http://ws.memoria/", className = "wsconsume.GetDataFiltro")
    @ResponseWrapper(localName = "getDataFiltroResponse", targetNamespace = "http://ws.memoria/", className = "wsconsume.GetDataFiltroResponse")
    @Action(input = "http://ws.memoria/wsTransformador/getDataFiltroRequest", output = "http://ws.memoria/wsTransformador/getDataFiltroResponse")
    public String getDataFiltro(
        @WebParam(name = "capa", targetNamespace = "")
        String capa,
        @WebParam(name = "latSurOesteVisor", targetNamespace = "")
        Double latSurOesteVisor,
        @WebParam(name = "lonSurOesteVisor", targetNamespace = "")
        Double lonSurOesteVisor,
        @WebParam(name = "latNorEsteVisor", targetNamespace = "")
        Double latNorEsteVisor,
        @WebParam(name = "lonNorEsteVisor", targetNamespace = "")
        Double lonNorEsteVisor);

    /**
     * 
     * @param params
     * @return
     *     returns java.lang.String
     */
    @WebMethod
    @WebResult(targetNamespace = "")
    @RequestWrapper(localName = "getData", targetNamespace = "http://ws.memoria/", className = "wsconsume.GetData")
    @ResponseWrapper(localName = "getDataResponse", targetNamespace = "http://ws.memoria/", className = "wsconsume.GetDataResponse")
    @Action(input = "http://ws.memoria/wsTransformador/getDataRequest", output = "http://ws.memoria/wsTransformador/getDataResponse")
    public String getData(
        @WebParam(name = "params", targetNamespace = "")
        String params);

}