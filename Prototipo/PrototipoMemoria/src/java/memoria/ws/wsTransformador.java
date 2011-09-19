/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.ws;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.dataAccess.query.filtro.RectangleFilter;
import memoria.commons.structures.GeoReferenced;
import memoria.commons.structures.Point;
import memoria.commons.structures.coordinates.LatLonCoordinate;
import memoria.dataAccess.RepositoriesManager;
import memoria.dataAccess.SpatialDTO;

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
       //En este método recibo la consulta como un xml, la desarmo con XStream
       //y la paso a objeto
        XStream xstream = new XStream(new DomDriver());
        try {
            VisualQuery query = (VisualQuery) xstream.fromXML(params);

            RepositoriesManager repoManager = new RepositoriesManager();
            List<GeoReferenced> results = repoManager.getData(query);
            return xstream.toXML(results);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
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
        Point southWest = new Point(new LatLonCoordinate(latSurOesteVisor, lonSurOesteVisor));
        Point norEast = new Point(new LatLonCoordinate(latNorEsteVisor, lonNorEsteVisor));
        RectangleFilter filtro = new RectangleFilter(southWest, norEast);

        RepositoriesManager repoManager = new RepositoriesManager();

        VisualQuery consulta = new VisualQuery(capa, filtro);
        XStream xstream = new XStream(new DomDriver());
        return xstream.toXML(repoManager.getData(consulta));
    }

    

    

}
