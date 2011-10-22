
import com.thoughtworks.xstream.XStream;
import java.util.ArrayList;
import java.util.List;
import memoria.commons.structures.*;
import memoria.commons.structures.coordinates.*;
//import memoria.commons.structures.coordinates.LatLonCoordinate;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran
 */
public class MainClass {

     public static void main(String [] args)
    {
         System.out.println("Empieza");
        /* XStream st = new XStream();

         //TEST: UN PUNTO
         Coordinate c1 = new LatLonCoordinate("-36.123","-57.312");
         Point p1 = new Point(c1);

         //TEST: UNA LINEA
         Coordinate c2 = new LatLonCoordinate("-37.123","-57.412");
         Coordinate c3 = new LatLonCoordinate("-38.123","-57.612");
         Coordinate c4 = new LatLonCoordinate("-39.123","-57.712");
         Coordinate c5 = new LatLonCoordinate("-40.123","-58.112");

         Point p2 = new Point(c2);
         Point p3 = new Point(c3);
         Point p4 = new Point(c4);
         Point p5 = new Point(c5);
         List<Point> points = new ArrayList<Point>();
         points.add(p2);
         points.add(p3);
         points.add(p4);
         points.add(p5);
         Line l1 = new Line();
         l1.setPoints(points);

         //TEST: UN POLIGONO
         Coordinate c6 = new LatLonCoordinate("-32.123","-55.412");
         Coordinate c7 = new LatLonCoordinate("-33.123","-54.612");
         Coordinate c8 = new LatLonCoordinate("-34.123","-53.712");
         Coordinate c9 = new LatLonCoordinate("-35.123","-52.112");

         Point p6 = new Point(c2);
         Point p7 = new Point(c3);
         Point p8 = new Point(c4);
         Point p9 = new Point(c5);

         List<Point> polPoints = new ArrayList<Point>();
         polPoints.add(p2);
         polPoints.add(p3);
         polPoints.add(p4);
         polPoints.add(p5);


         Polygon pol1 = new Polygon();
         pol1.setPoints(polPoints);

         ArrayList<AbstractGeographicElement> lista = new ArrayList<AbstractGeographicElement>();
         lista.add(p1);
         lista.add(l1);
         lista.add(pol1);
         String result = st.toXML(lista);
         ManejadorRespuesta mR = new ManejadorRespuesta();
         mR.ParsearRespuesta(result);*/

        /* try { // Call Web Service Operation
             broker.geoconsulta.modulos.ReceptorConsultaComponentService service = new broker.geoconsulta.modulos.ReceptorConsultaComponentService();
             broker.geoconsulta.modulos.ReceptorConsultaComponent port = service.getReceptorConsultaComponentPort();
             // TODO initialize WS operation arguments here
             Coordinate centro = new LatLonCoordinate(-34.916231483608684d,-34.916231483608684d);
             Coordinate puntaSW  = new LatLonCoordinate (-34.916231483608684d,-56.406866500781234d);
             Coordinate puntaNE = new LatLonCoordinate(-34.705948282647874d,-55.917974899218734d);
             String[] capas = new String[1];
             capas[0] = "Escuelas";
             Consultador cons = new Consultador();
             String laCons = cons.generarConsulta(puntaNE, puntaSW, centro, capas);


             java.lang.String arg0 = laCons;
             // TODO process result here
             java.lang.String result = port.obtenerGeoInfo(arg0);
             System.out.println("Result = "+result);
         } catch (Exception ex) {
             ex.getMessage();
             ex.printStackTrace();
         }
*/


         try { // Call Web Service Operation
         memoria.ws.WsTransformadorService service = new memoria.ws.WsTransformadorService();
         memoria.ws.WsTransformador port = service.getWsTransformadorPort();
         // TODO initialize WS operation arguments here
         java.lang.String capa = "Comisarias";
         java.lang.Double latSurOesteVisor = Double.valueOf(-34.916231483608684d);
         java.lang.Double lonSurOesteVisor = Double.valueOf(-56.406866500781234d);
         java.lang.Double latNorEsteVisor = Double.valueOf(-34.705948282647874d);
         java.lang.Double lonNorEsteVisor = Double.valueOf(-55.917974899218734d);
         // TODO process result here
         java.lang.String result = port.getDataFiltro(capa, latSurOesteVisor, lonSurOesteVisor, latNorEsteVisor, lonNorEsteVisor);
         System.out.println("Result del Negro = "+result);
     } catch (Exception ex) {
         // TODO handle custom exceptions here
     }


        // ManejadorRespuesta mR = new ManejadorRespuesta();
         //mR.CommitKML("22");
         Validador val = new Validador();
         //val.EmpezarTest();
         Cronometer cron = new Cronometer();
         //cron.empezarTest();
         //val.EmpezarTest();
        //ManejadorRespuesta mR = new ManejadorRespuesta();
         //mR.TestValidar();
         try{
          //   val.validar();
         }catch(Exception e)
         {
             System.out.println("AAASADDSA " + e.getMessage());
         }


        //mR.TestLlenarArray();
        //mR.generarArchivoKML();


        System.out.println("END");
    }




}
