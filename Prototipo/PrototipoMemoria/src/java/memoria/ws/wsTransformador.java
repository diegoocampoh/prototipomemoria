/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.ws;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author diego
 */
@WebService()
public class wsTransformador {


    /**
     * Servicio que recibe la consulta en XML y retorna los resultados
     * en XML
     *
     * @param params. Consulta XML
     * @return
     */
    @WebMethod(operationName = "getData")
    public String getData(@WebParam(name = "params")
    String params) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     *
     * Servicio que recibe por parametro la consulta y los resultados los
     * retorna en XML.
     *
     *
     * @param capa - El nombre de la capa a consultar .Ej.:"Escuelas"
     * @param latSurOesteVisor - Latitud en decimal de la esquina sur-oeste del visor
     * @param lonSurOesteVisor - Longitud en decimal de la esquina sur-oeste del visor
     * @param latNorEsteVisor - Latitud en decimal de la esquina nor-este del visor
     * @param lonNorEsteVisor - Longitud en decimal de la esquina este-este del visor
     * @return
     */
    @WebMethod(operationName = "getDataFiltro")
    public String getDataFiltro(@WebParam(name = "capa")
    String capa, @WebParam(name = "latSurOesteVisor")
    Double latSurOesteVisor, @WebParam(name = "lonSurOesteVisor")
    Double lonSurOesteVisor, @WebParam(name = "latNorEsteVisor")
    Double latNorEsteVisor, @WebParam(name = "lonNorEsteVisor")
    Double lonNorEsteVisor) {

        


        return null;
    }

    

    

}
