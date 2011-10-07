
import com.thoughtworks.xstream.XStream;
import java.io.BufferedWriter;
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
        Coordenadas lasCoord = new Coordenadas(Double.parseDouble(unPoint.getCoordiante().getX()), Double.parseDouble(unPoint.getCoordiante().getY()));
        Punto resultPunto = new Punto(lasCoord);
        return resultPunto;

    }
    private Poligono convertirAPoligono(Polygon a)
    {
        List<Point> puntos = a.getPoints();
        ArrayList<Coordenadas> CoordenadasPoligono = new ArrayList<Coordenadas>();
        for(Point p : puntos)
        {            
            Coordenadas unaCoord = new Coordenadas(Double.parseDouble(p.getCoordiante().getX()), Double.parseDouble(p.getCoordiante().getY()));
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
            Coordenadas unaCoord = new Coordenadas(Double.parseDouble(p.getCoordiante().getX()), Double.parseDouble(p.getCoordiante().getY()));
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
          ArrayList<AbstractGeographicElement> listaDeElementos;
          listaDeElementos = (ArrayList<AbstractGeographicElement>)st.fromXML(xml);
          System.out.println("Fue transformado a objetos exitosamente");
          for(AbstractGeographicElement a : listaDeElementos)
          {
              if(a.getTypeRepresentation().equals("Point"))
              {
                  System.out.println("Es un Punto");
                  Punto unPunto = convertirAPunto((Point)a);
                  listaParseada.add(unPunto);
              }else
                  if(a.getTypeRepresentation().equals("Polygon"))
                  {
                      System.out.println("Es un Poligono");
                      Poligono unPoligono = convertirAPoligono((Polygon)a);
                      listaParseada.add(unPoligono);
                  }
                  else
                  {
                    if(a.getTypeRepresentation().equals("Line"))
                    {
                        System.out.println("Es una linea");
                        Linea unaLinea =  convertirALinea((Line) a);
                        listaParseada.add(unaLinea);
                    }
                  }
                  
          }
          System.out.println("Termina exitosamente");
          return listaParseada;



    }

    public void RecibirXML()
    {
                 XStream st = new XStream();

         //TEST: UN PUNTO
         Coordinate c1 = new LatLonCoordinate("-30.123","-57.312");
         Point p1 = new Point(c1);

         //TEST: UNA LINEA
         Coordinate c2 = new LatLonCoordinate("-31.123","-57.412");
         Coordinate c3 = new LatLonCoordinate("-32.123","-57.612");
         Coordinate c4 = new LatLonCoordinate("-33.123","-57.712");
         Coordinate c5 = new LatLonCoordinate("-34.123","-58.112");

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
         Coordinate c6 = new LatLonCoordinate("-35.123","-55.412");
         Coordinate c7 = new LatLonCoordinate("-36.123","-54.612");
         Coordinate c8 = new LatLonCoordinate("-37.123","-53.712");
         Coordinate c9 = new LatLonCoordinate("-38.123","-52.112");

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
    public void TestLlenarArray()
    {
        Coordenadas c1 = new Coordenadas(-36.123,-56.312);
        Coordenadas c10 = new Coordenadas(-32.5675123,-57.8888432);
        Coordenadas c11 = new Coordenadas(-33.765123,-57.4999932);
        Coordenadas c12 = new Coordenadas(-31.14623,-57.47772);

        ArrayList<Coordenadas> array1 = new ArrayList<Coordenadas>();
        array1.add(c1);
        array1.add(c10);
        array1.add(c11);
        array1.add(c12);

        Linea l1 = new Linea(array1);

        Coordenadas c2 = new Coordenadas(-36.123,-56.312);
        Coordenadas c20 = new Coordenadas(-34.123,-57.232);
        Coordenadas c21 = new Coordenadas(-33.123,-58.432);
        Coordenadas c22 = new Coordenadas(-36.123,-56.312);

        ArrayList<Coordenadas> array2 = new ArrayList<Coordenadas>();
        array2.add(c2);
        array2.add(c20);
        array2.add(c21);
        array2.add(c22);

        Coordenadas c3 = new Coordenadas(-37.123, -56.312);
        Punto po1 = new Punto(c3);

        Poligono p1 = new Poligono (array2);


        this.listaElementos = new ArrayList<ElemGeograf>();
        this.listaElementos.add(l1);
        this.listaElementos.add(p1);
        this.listaElementos.add(po1);

    }
    public void generarArchivoKML ()
    {
        //C:\Program Files\SlikSvn\bin
        String fileName = "C:\\Users\\Fran\\prototipomemoria\\Prototipo\\KMLs\\OtroNuevo.kml";
        String NombreArchivo = "ArchivoKML.kml";
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
            //CommitKML(NombreArchivo);
        }catch(IOException e)
        {
            e.printStackTrace();
        }

        //C:\Program Files\SlikSvn\bin
    }
    public void CommitKML(String rutaArchivo)
    {try
     {
         System.out.println("Empieza el commit");
         Process p2;
         //try {
                //p2= Runtime.getRuntime().exec("C:\\Users\\Fran\\prototipomemoria\\Prototipo\\KMLs");
                //int val1 = p2.waitFor();
                //System.out.println("error" + val1);
           // } catch (InterruptedException ex) {
             //   Logger.getLogger(ManejadorRespuesta.class.getName()).log(Level.SEVERE, null, ex);
            //}

         System.out.println("Pasa el primero");
         p2 = Runtime.getRuntime().exec("C:\\Program Files\\SlikSvn\\bin commit ArchivoKML.kml -m=\"Subo KML generado\"");
         System.out.println("No termina");
         int exitVal;
            try {
                System.out.println("No termjjjjjina");
                exitVal = p2.waitFor();
                System.out.println("Termina con error " + exitVal);
            } catch (InterruptedException ex) {
                System.out.println("ERRRRORRRR");
                Logger.getLogger(ManejadorRespuesta.class.getName()).log(Level.SEVERE, null, ex);
            }

//No puedo ejecutarlo
     }catch(IOException e)
     {
            System.out.println("Exception "+e.getMessage());
     }


    }





    

}
