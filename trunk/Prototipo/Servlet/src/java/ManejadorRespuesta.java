
import com.thoughtworks.xstream.XStream;
import java.io.BufferedWriter;
import javax.xml.validation.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import memoria.commons.structures.*;
import memoria.commons.structures.coordinates.Coordinate;
import memoria.commons.structures.coordinates.LatLonCoordinate;


/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran
 */
public class ManejadorRespuesta {
     ArrayList<ElemGeograf> listaElementos;
    private Punto convertirAPunto(Point unPoint)
    {
        Coordenadas lasCoord = new Coordenadas(Double.parseDouble(unPoint.getCoordiante().getY()), Double.parseDouble(unPoint.getCoordiante().getX()));
        Punto resultPunto = new Punto(lasCoord);
        return resultPunto;

    }
    private Poligono convertirAPoligono(Polygon a)
    {
        List<Point> puntos = a.getPoints();
        ArrayList<Coordenadas> CoordenadasPoligono = new ArrayList<Coordenadas>();
        for(Point p : puntos)
        {            
            Coordenadas unaCoord = new Coordenadas(Double.parseDouble(p.getCoordiante().getY()), Double.parseDouble(p.getCoordiante().getX()));
            CoordenadasPoligono.add(unaCoord);
        }
        Poligono resultado = new Poligono(CoordenadasPoligono);
        return resultado;
    }
    private Linea convertirALinea(Line a)
    {
        List<Point> puntos = a.getPoints();
        ArrayList<Coordenadas> CoordenadasLinea = new ArrayList<Coordenadas>();
        for(Point p: puntos)
        {
            Coordenadas unaCoord = new Coordenadas(Double.parseDouble(p.getCoordiante().getY()), Double.parseDouble(p.getCoordiante().getX()));
            CoordenadasLinea.add(unaCoord);
        }
        Linea resultado = new Linea(CoordenadasLinea);
        return resultado;
    }
    public ArrayList<ElemGeograf> ParsearRespuesta(String xml)
    {
          System.out.println("Entra el xml a ser paresado");
          ArrayList<ElemGeograf> listaParseada = new ArrayList<ElemGeograf>();
          XStream st = new XStream();
          ArrayList<GeoReferenced> listaDeElementos;
          listaDeElementos = (ArrayList<GeoReferenced>)st.fromXML(xml);
          System.out.println("Fue transformado a objetos exitosamente");
          for(GeoReferenced a : listaDeElementos)
          {
              if(a.getSpatialRepresentation().getTypeRepresentation().equals("Point"))
              {
                  System.out.println("Es un Punto");
                  Punto unPunto = convertirAPunto((Point)a.getSpatialRepresentation());
                  listaParseada.add(unPunto);
              }else
                  if(a.getSpatialRepresentation().getTypeRepresentation().equals("Polygon"))
                  {
                      System.out.println("Es un Poligono");
                      Poligono unPoligono = convertirAPoligono((Polygon)a.getSpatialRepresentation());
                      listaParseada.add(unPoligono);
                  }
                  else
                  {
                    if(a.getSpatialRepresentation().getTypeRepresentation().equals("Line"))
                    {
                        System.out.println("Es una linea");
                        Linea unaLinea =  convertirALinea((Line) a.getSpatialRepresentation());
                        listaParseada.add(unaLinea);
                    }
                  }
                  
          }
          System.out.println("Termina exitosamente el parseo de la respuesta");
          return listaParseada;



    }

    public void ConcetarWSDatos(Coordinate esqNE, Coordinate esqSW, String strcapa)
    {
        try { // Call Web Service Operation
            System.out.println("Esta conectandose con el web service");
         memoria.ws.WsTransformadorService service = new memoria.ws.WsTransformadorService();
         memoria.ws.WsTransformador port = service.getWsTransformadorPort();

         LatLonCoordinate NE = (LatLonCoordinate)esqNE;
         LatLonCoordinate SW = (LatLonCoordinate)esqSW;
         // TODO initialize WS operation arguments here
         java.lang.String capa = strcapa;
         java.lang.Double latSurOesteVisor = SW.getLatitude();//Double.valueOf(-34.916231483608684d);
         java.lang.Double lonSurOesteVisor = SW.getLongitude();//Double.valueOf(-56.406866500781234d);
         java.lang.Double latNorEsteVisor = NE.getLatitude();//Double.valueOf(-34.705948282647874d);
         java.lang.Double lonNorEsteVisor = NE.getLongitude();//Double.valueOf(-55.917974899218734d);
         // TODO process result here
         java.lang.String result = port.getDataFiltro(capa, latSurOesteVisor, lonSurOesteVisor, latNorEsteVisor, lonNorEsteVisor);
         //System.out.println("Result del Negro = "+result);
         System.out.println("Obtuvo el resultado del webservice : "+result);
         this.listaElementos = ParsearRespuesta(result);
         
         this.generarArchivoKML();

     } catch (Exception ex) {
         System.out.print(ex.getMessage());
         ex.printStackTrace();
     }
    }

    public void RecibirXML()
    {
                 XStream st = new XStream();

         //TEST: UN PUNTO
         Coordinate c1 = new LatLonCoordinate("-30.123","-57.312");
         Point p1 = new Point(c1);

         //TEST: UNA LINEA
         Coordinate c2 = new LatLonCoordinate("-31.23","-56.412");
         Coordinate c3 = new LatLonCoordinate("-32.123","-56.612");
         Coordinate c4 = new LatLonCoordinate("-33.123","-56.712");
         Coordinate c5 = new LatLonCoordinate("-34.123","-56.112");

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
         Coordinate c6 = new LatLonCoordinate("-35.123","-50.412");
         Coordinate c7 = new LatLonCoordinate("-36.333123","-51.231612");
         Coordinate c8 = new LatLonCoordinate("-37.36123","-51.712555");
         Coordinate c9 = new LatLonCoordinate("-38.111123","-52.112");

         Point p6 = new Point(c6);
         Point p7 = new Point(c7);
         Point p8 = new Point(c8);
         Point p9 = new Point(c9);

         List<Point> polPoints = new ArrayList<Point>();
         polPoints.add(p6);
         polPoints.add(p7);
         polPoints.add(p8);
         polPoints.add(p9);


         Polygon pol1 = new Polygon();
         pol1.setPoints(polPoints);

         ArrayList<AbstractGeographicElement> lista = new ArrayList<AbstractGeographicElement>();
         lista.add(p1);
         lista.add(l1);
         lista.add(pol1);
         String result = st.toXML(lista);
         this.listaElementos = ParsearRespuesta(result);

         this.generarArchivoKML();

    }
    public void generarArchivoKML ()
    {
        //C:\Program Files\SlikSvn\bin
        //String fileName = "C:\\Users\\Fran\\Desktop\\Validaciones\\Test01.kml C:\\Users\\Fran\\prototipomemoria\\Prototipo\\KMLs\\KMLFB.kml";
        System.out.println("Empieza a generar el KML");
        String fileName = "/var/www/html/kml/Resultado.kml";//"C:\\Users\\Fran\\prototipomemoria\\Prototipo\\KMLs\\Fuego3.kml";//
        FileWriter fw;
        BufferedWriter bw;
        String archivo = "<?xml version=\"1.0\" encoding=\"UTF-8\"?> \n <kml xmlns=\"http://www.opengis.net/kml/2.2\"> \n <Document>\n";
        for(ElemGeograf e:listaElementos)
        {
            archivo = archivo + e.ToKml(0);
        }
        archivo = archivo + "</Document> \n </kml>";
        try{	    
            fw = new FileWriter(fileName);
            bw = new BufferedWriter(fw);
            bw.write(archivo);
            bw.close();
            fw.close();
	    System.out.println("Se escribe el kml exitosamente");
            
        }catch(IOException e)
        {
            e.printStackTrace();
        }
       // System.out.println("llamo aca a lo que quiero llamar");
        

       
    }
    





    

}
