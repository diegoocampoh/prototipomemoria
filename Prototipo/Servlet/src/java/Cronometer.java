

import com.thoughtworks.xstream.XStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import memoria.commons.structures.AbstractGeographicElement;
import memoria.commons.structures.Line;
import memoria.commons.structures.Point;
import memoria.commons.structures.Polygon;
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
public class Cronometer {

    int maxPtosLinea=35;
    int poblacion=385;

    public void empezarTest()
    {
        List<Long> tiempos = new ArrayList<Long>();
        for (int i = 0 ; i < this.poblacion ; i = i + 1)
        {
           List<AbstractGeographicElement> lista = this.cantidadElementos();
           XStream st = new XStream();
           String result = st.toXML(lista);
           long a =  System.currentTimeMillis();
           //System.out.println("Empieza "+ a);
           List<ElemGeograf> listaElementos = this.ParsearRespuesta(result);
           this.generarArchivoKML(i,listaElementos);
           long b = System.currentTimeMillis();
           //System.out.println("Termina "+b);
           System.out.println("Test "+i+" duro "+(b-a) + " milisegundos");
           tiempos.add(b-a);
        }
        //cargar resultados de la consulta aleatoriamente
        System.out.println("Total "+poblacion);
        //calcular media

        double media;
        double sumatoriaM = 0;
        for(int i = 0 ; i < poblacion ; i = i+1)
        {
            sumatoriaM = sumatoriaM + tiempos.get(i);
        }
        media = (1.0/poblacion) * sumatoriaM;


        //calcular desviacion;
        double desviacion;
        double sumatoriaD = 0;
        for(int  i = 0 ; i < poblacion ; i = i + 1)
        {
            sumatoriaD = sumatoriaD + Math.pow((tiempos.get(i) - media),2);
        }
        desviacion = Math.sqrt(sumatoriaD/poblacion);


        System.out.println("Media "+media+" desviacion "+desviacion);
    }

    private List<AbstractGeographicElement> cantidadElementos()
    {
             Random r = new Random();
             int max=300;
             int cantPoligonos;
             int cantPtos;
             int cantLineas;
             cantPoligonos = r.nextInt(max);
             cantPtos = r.nextInt(max);
             cantLineas = r.nextInt(max);
            return this.fill(cantPoligonos, cantPtos, cantLineas);

    }
    public List<AbstractGeographicElement> fill(int cantPoligonos, int cantPtos, int cantLineas)
    {
             System.out.println("Pol "+cantPoligonos + " lines " +cantLineas + " Ptos "+ cantPtos);
             List<AbstractGeographicElement> listaElementos = new ArrayList<AbstractGeographicElement>();
             for(int topePol = 0 ; topePol < cantPoligonos ; topePol = topePol + 1)
             {
                 Polygon pol= this.hacerPol();
                 listaElementos.add(pol);

             }
             for(int topePto = 0 ; topePto < cantLineas ; topePto = topePto + 1)
             {
                 Point pto = this.hacerPto();
                 listaElementos.add(pto);

             }for(int topeLin = 0 ; topeLin < cantPtos ; topeLin = topeLin + 1)
             {
                 Line uline = this.hacerLine();
                 listaElementos.add(uline);
             }
             return listaElementos;
         }

    private Polygon hacerPol() {
         List<Point> points = new ArrayList<Point>();
         Random r = new Random();
             int cantidadDePuntos = r.nextInt(maxPtosLinea);
             while(cantidadDePuntos == 0)
             {
                 cantidadDePuntos = r.nextInt(maxPtosLinea);
             }
             for(int cPto = 0 ; cPto < cantidadDePuntos; cPto = cPto + 1)
             {
                 Point p= hacerPto();
                 points.add(p);
             }

             Polygon poli = new Polygon();
             poli.setPoints(points);
             return poli;
    }

    private Point hacerPto() {
         Coordinate c1 = this.hacerCoord();
         Point p1 = new Point(c1);
         return p1;
    }

    private Coordinate hacerCoord()
    {
        Random r = new Random();
             double lat = r.nextDouble()*100;
             double lon = r.nextDouble()*100;
             while(lat<10 || lat>90)
             {
                 lat = r.nextDouble()*100;
             }
             while(lon<10 || lon>90)
             {
                 lon = r.nextDouble()*100;
             }
             if(r.nextBoolean())
             {
               lat = lat * -1;
             }
             if(r.nextBoolean())
             {
                 lon = lon * -1;
             }
             //System.out.println(lat + " " + lon);
             Coordinate c= new LatLonCoordinate(lat, lon);
             return c;
    }

    private Line hacerLine() {
        List<Point> points = new ArrayList<Point>();
        Random r = new Random();
             int cantidadDePuntos = r.nextInt(maxPtosLinea);
             while(cantidadDePuntos == 0)
             {
                 cantidadDePuntos = r.nextInt(maxPtosLinea);
             }
             for(int cPto = 0 ; cPto < cantidadDePuntos; cPto = cPto + 1)
             {
                 Point p= hacerPto();
                 points.add(p);
             }

             Line linea = new Line();
             linea.setPoints(points);
             return linea;
    }

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
          //System.out.println("Entra el xml a ser paresado");
          ArrayList<ElemGeograf> listaParseada = new ArrayList<ElemGeograf>();
          XStream st = new XStream();
          ArrayList<AbstractGeographicElement> listaDeElementos;
          listaDeElementos = (ArrayList<AbstractGeographicElement>)st.fromXML(xml);
        //  System.out.println("Fue transformado a objetos exitosamente");
          for(AbstractGeographicElement a : listaDeElementos)
          {
              if(a.getTypeRepresentation().equals("Point"))
              {
          //        System.out.println("Es un Punto");
                  Punto unPunto = convertirAPunto((Point)a);
                  listaParseada.add(unPunto);
              }else
                  if(a.getTypeRepresentation().equals("Polygon"))
                  {
            //          System.out.println("Es un Poligono");
                      Poligono unPoligono = convertirAPoligono((Polygon)a);
                      listaParseada.add(unPoligono);
                  }
                  else
                  {
                    if(a.getTypeRepresentation().equals("Line"))
                    {
              //          System.out.println("Es una linea");
                        Linea unaLinea =  convertirALinea((Line) a);
                        listaParseada.add(unaLinea);
                    }
                  }

          }
          //System.out.println("Termina exitosamente");
          return listaParseada;
    }

    public void generarArchivoKML (int numeroDelArchivo, List<ElemGeograf> listaElementos)
    {
        //C:\Program Files\SlikSvn\bin
       // String fileName = "C:\\Users\\Fran\\Desktop\\Validaciones\\Cronometro\\Test01.kml";
        String fileName = "C:\\Users\\Fran\\Desktop\\Validaciones\\Cronometro\\Test"+numeroDelArchivo+".kml";
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

        }catch(IOException e)
        {
            e.printStackTrace();
        }
        //System.out.println("llamo aca a lo que quiero llamar");
        //
        // CommitKML(NombreArchivo);


    }
    


}
