
import com.thoughtworks.xstream.XStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import memoria.commons.dataAccess.query.UserQuery;
import memoria.commons.dataAccess.query.filtro.RectangleFilter;
import memoria.commons.structures.WMSConsult;
import memoria.commons.*;
import memoria.commons.structures.Point;
import memoria.commons.structures.coordinates.Coordinate;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran
 */
public class Consultador {

    public String generarConsulta(Coordinate esqNE, Coordinate esqSW, Coordinate centro, String[] capas)
    {
        try
        {
            System.out.println("Llego la consulta");
            for (int i = 0 ; i < capas.length ; i= i +1)
            {
                System.out.println("Las capas "+capas[i]);
            }
            XStream st = new XStream();
        //st.alias("WMSConsult", WMSConsult.class);


        //hay que corregir estas cosas pero ya esta saliendo
        /*WMSConsult consulta = new WMSConsult();

        consulta.setCentro(centro);
        consulta.setNE(esqNE);
        consulta.setSW(esqSW);
        consulta.setCapas(capas);
        System.out.println("Hasta aca llega");
        String xml = st.toXML(consulta);

        System.out.println(xml);

        
        System.out.println("Se rompe");
        //String NombreArchivo = "ArchivoKML.kml";
         *
         */
        //String fileName = "C:\\Users\\Fran\\Consulta.txt";
        List<String> lasCapas = new ArrayList<String>();
        for(String c : capas)
        {
            lasCapas.add(c);
        }
        RectangleFilter rf = new RectangleFilter();
        Point NE = new Point();
        NE.setCoordiante(esqNE);
        Point SW = new Point();
        SW.setCoordiante(esqSW);


        rf.setNorthEast(NE);
        rf.setSouthWest(SW);
        UserQuery UQ = new UserQuery(lasCapas, rf);
        String xml = st.toXML(UQ);

        //FileWriter fw;
        //BufferedWriter bw;

        //try{
          //  fw = new FileWriter(fileName);
           // bw = new BufferedWriter(fw);
            //bw.write(xml);
            //bw.close();
            //fw.close();
            ManejadorRespuesta man = new ManejadorRespuesta();
            man.ConcetarWSDatos(esqNE, esqSW, "Comisarias");
            
            //man.RecibirXML();
             return xml;

        //}catch(IOException e)
        //{
          ///  e.printStackTrace();
        //}

        }catch(Exception e)
        {
            System.out.println(e.getMessage());
            return null;
        }
        


    }

}
