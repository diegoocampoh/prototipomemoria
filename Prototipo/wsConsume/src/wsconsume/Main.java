/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package wsconsume;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.ws.Dispatch;
import javax.xml.transform.stream.StreamSource;
import javax.xml.ws.Service;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import memoria.commons.dataAccess.RepoConfig;
import memoria.commons.dataAccess.RepositoriesMetadata;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.dataAccess.query.filtro.RectangleFilter;
import memoria.commons.entities.Escuela;
import memoria.commons.structures.GeoReferenced;
import memoria.commons.structures.Point;
import memoria.commons.structures.coordinates.LatLonCoordinate;
import memoria.commons.xml.XStreamInstance;



/**
 *
 * @author diego
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        long sum = 0;
        int times = 100;
        for (int i = 0; i <times; i++) {
            long uno = new Date().getTime();

            getData(args);
            long dos = new Date().getTime();
            System.out.println(dos - uno);
            sum+= dos - uno;
            //System.out.println(da.getDataAccessPort().getData(null));
        }
        System.out.println("Suma: "+sum);
        System.out.println("Ejecuciones: "+times);
        System.out.println("Promedio: "+sum/times);
        
    }


    public static void getData(String[] args){
        WsTransformadorService servicio = new WsTransformadorService();

        String capa = "Industria";

//        double SWlat = Double.valueOf(args[0]);
//        double SWlon = Double.valueOf(args[1]);
//        double NElat = Double.valueOf(args[2]);
//        double NElon = Double.valueOf(args[3]);

//        double SWlat = -34.92577121781642;
//        double SWlon = -56.204938888549805;
//        double NElat = -34.89057762229523;
//        double NElon = -56.1276912689209;
        
        double SWlat = -36.92577121781642;
        double SWlon = -58.204938888549805;
        double NElat = -30.89057762229523;
        double NElon = -50.1276912689209;


//        RepositoriesMetadata meta = new RepositoriesMetadata();
//        meta.setEntity("Escuela");
//        RepoConfig config = new RepoConfig("memoria.dataAccess.dao.ExcelDao");
//        config.getAttributes().put("URL", "D:/facu/Memoria/prototipo-googlecode/Prototipo/PrototipoMemoria/src/java/memoria/resources/industri.xls");
//        meta.getRepositories().add(config);
//        List<RepositoriesMetadata> repositoriesMetadata = new ArrayList<RepositoriesMetadata>();
//        repositoriesMetadata.add(meta);
//        System.out.println(XStreamInstance.toXml(repositoriesMetadata));

        VisualQuery consulta = new VisualQuery(capa);

         String xmlResponse = servicio.getWsTransformadorPort().getDataFiltro
                (capa,SWlat,SWlon,NElat,NElon);

         //String xmlResponse = servicio.getWsTransformadorPort().getData(consulta.toXml());
         //createMap(xmlResponse);
    }

    public static void createMap(String xml){
        writeToFile(xml);
        try {
            Process p = Runtime.getRuntime().exec("python pymap.py");
            //Process p2 = Runtime.getRuntime().exec("C:/Program Files (x86)/SlikSvn/bin/svn commit MyFirstMap.html -m=\"Subo mapa generado\"");
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void writeToFile(String xml){
        try{
          // Create file
          List<GeoReferenced> data = (List<GeoReferenced>) XStreamInstance.toObject(xml);

          

          FileWriter fstream = new FileWriter("data.csv");
          BufferedWriter out = new BufferedWriter(fstream);
          int i = 0;
            for (GeoReferenced geoReferenced : data) {
                for (Point punto : geoReferenced.getSpatialRepresentation().getPoints()){
                    out.write(punto.getCoordiante().getX());
                    out.write(" ; ");
                    out.write(punto.getCoordiante().getY());
                    out.write(" ; ");
                    out.write(geoReferenced.getNombre());
                    out.write(" ; ");
                    out.write(geoReferenced.getDescripcion());
                    out.write(" ; ");
                    out.write(geoReferenced.getIconName());
                    out.write("\n");
                    i+=1;
                }
                
            }

          System.out.println("Procesando mapa para "+i+ " puntos");
          out.close();
          }catch (Exception e){//Catch exception if any
          System.err.println("Error: " + e.getMessage());
          }
    }
}
