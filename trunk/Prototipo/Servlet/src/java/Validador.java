
//import de.micromata.opengis.kml.v_2_2_0.Kml;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import org.xml.sax.SAXException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran
 */
public class Validador {

  // List<ElemGeograf> listaElementos;
    int maxPtosLinea = 40;
    int poblacion = 200;
         public  void validar (String fileNames) throws SAXException, IOException
         {

         //System.out.println("1");
        // 1. Lookup a factory for the W3C XML Schema language
        SchemaFactory factory =
            SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
        //System.out.println("2");
        // 2. Compile the schema.
        // Here the schema is loaded from a java.io.File, but you could use
        // a java.net.URL or a javax.xml.transform.Source instead.
        File schemaLocation = new File("C:\\Users\\Fran\\Desktop\\ogckml22.xsd");
      //  System.out.println("Que pasa");
        Schema schema = factory.newSchema(schemaLocation);
      //  System.out.println(" 3");
        // 3. Get a validator from the schema.
        Validator validator = schema.newValidator();
       // System.out.println("4 ");
        // 4. Parse the document you want to check.
        System.out.println(fileNames);
        FileInputStream f = new FileInputStream(new File("C:\\Users\\Fran\\Desktop\\Validaciones\\"+fileNames+".kml"));
        Source source = new StreamSource(f);
   //     System.out.println("5 ");
        // 5. Check the document
        try {
     //       System.out.println("6 ");
            validator.validate(source);
       //     System.out.println("7");
            System.out.println(" is valid.");
        }
        catch (Exception ex) {
            System.out.println(" is not valid because ");
         //   System.out.println(" 8");
            System.out.println(ex.getMessage());
        }
     }
         public void EmpezarTest()
         {
             
             List<ElemGeograf> lista;
             for(int i=0 ; i < poblacion ; i= i +1)
             {
                 //Se generan los numeros randomicos de poligonos, ptos y lineas
                 //Se hacen esos elem geograf y vuelven en una array
                 System.out.println("Test "+i);
                 lista = startFill();
                 //se pasa esa lista de elem geograf a archivo
                 this.TgenerarArchivo(i, lista);
             }

             for(int j = 0 ; j < poblacion ; j = j + 1)
             {
                 String fileNames = "Test"+j;
            try {
                this.validar(fileNames);
            } catch (Exception ex) {
                System.out.println("Exception es aca: " + ex.getMessage());
               //ex.printStackTrace();
            }
             }

        }
         private List<ElemGeograf> startFill()
         {
             Random r = new Random();
             int max=300;
             int cantPoligonos;
             int cantPtos;
             int cantLineas;
             cantPoligonos = r.nextInt(max);
             cantPtos = r.nextInt(max);
             cantLineas = r.nextInt(max);

             return this.FillElemGeograf(cantPoligonos, cantLineas, cantPtos);
         }
         private List<ElemGeograf> FillElemGeograf(int cantPoligonos, int cantLineas, int cantPtos)
         {
             System.out.println("Pol "+cantPoligonos + " lines " +cantLineas + " Ptos "+ cantPtos);
             List<ElemGeograf> listaElementos = new ArrayList<ElemGeograf>();
             for(int topePol = 0 ; topePol < cantPoligonos ; topePol = topePol + 1)
             {
                 Poligono pol= this.hacerPoligono();
                 listaElementos.add(pol);

             }
             for(int topePto = 0 ; topePto < cantLineas ; topePto = topePto + 1)
             {
                 Punto pto = this.hacerPunto();
                 listaElementos.add(pto);

             }for(int topeLin = 0 ; topeLin < cantPtos ; topeLin = topeLin + 1)
             {
                 Linea line = this.hacerLinea();
                 listaElementos.add(line);
             }
             return listaElementos;
         }

         private Punto hacerPunto()
         {
             Coordenadas c1 = hacerCoordenadas();
             Punto po1 = new Punto(c1);
             return po1;

         }
         private Linea hacerLinea()
         {
             Random r = new Random();
             int cantidadDePuntos = r.nextInt(maxPtosLinea);
             while(cantidadDePuntos < 2)
             {
                 cantidadDePuntos = r.nextInt(maxPtosLinea);
             }
             ArrayList<Coordenadas> ptos = new ArrayList<Coordenadas>();
             for(int cPto = 0 ; cPto < cantidadDePuntos; cPto = cPto + 1)
             {
                 Coordenadas c = hacerCoordenadas();
                 ptos.add(c);
             }

             Linea line = new Linea(ptos);
             return line;


         }
         private Poligono hacerPoligono()
         {
              Random r = new Random();
             int cantidadDePuntos = r.nextInt(maxPtosLinea);
             while(cantidadDePuntos < 4)
             {
                 cantidadDePuntos = r.nextInt(maxPtosLinea);
             }
             ArrayList<Coordenadas> ptos = new ArrayList<Coordenadas>();
             for(int cPto = 0 ; cPto < cantidadDePuntos; cPto = cPto + 1)
             {
                 Coordenadas c = hacerCoordenadas();
                 ptos.add(c);
             }

             Poligono pol = new Poligono(ptos);
             return pol;
         }

         private Coordenadas hacerCoordenadas()
         {
             Random r = new Random();
             double lat = r.nextDouble()*100;
             double lon = r.nextDouble()*100;
             while(lat<30 || lat>60)
             {
                 lat = r.nextDouble()*100;
             }
             while(lon<30 || lon>60)
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
             Coordenadas c= new Coordenadas(lat, lon);
             return c;
         }
         private void TLlenarArray()
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


       // this.listaElementos = new ArrayList<ElemGeograf>();
        //this.listaElementos.add(l1);
       // this.listaElementos.add(p1);
       // this.listaElementos.add(po1);

    }

         private void TgenerarArchivo (int numeroDelArchivo, List<ElemGeograf> listaElementos)
         {
        //C:\Program Files\SlikSvn\bin
        String fileName = "C:\\Users\\Fran\\Desktop\\Validaciones\\Test"+numeroDelArchivo+".kml";
        //String fileName = "C:\\Users\\Fran\\prototipomemoria\\Prototipo\\Servlet\\ArchCuatro.kml";
        //String NombreArchivo = "ArchivoKML.kml";
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




    }

}
