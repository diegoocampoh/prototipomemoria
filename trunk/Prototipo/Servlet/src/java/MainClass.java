
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

        // ManejadorRespuesta mR = new ManejadorRespuesta();
         //mR.CommitKML("22");
         Validador val = new Validador();
         //val.EmpezarTest();
         Cronometer cron = new Cronometer();
         //cron.empezarTest();
         val.EmpezarTest();
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
