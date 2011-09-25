/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.dataAccess.dao;

import com.csvreader.CsvReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.entities.EntidadPunto;
import memoria.commons.entities.Escuela;
import memoria.commons.structures.GeoReferenced;
import memoria.commons.structures.Point;
import memoria.commons.structures.coordinates.LatLonCoordinate;
import memoria.dataAccess.IRepositoryDao;

/**
 *
 * @author diego
 */
public class CsvDao implements IRepositoryDao{

     //Patron Singleton
    private static CsvDao instance;
    public static IRepositoryDao getInstance(){
        if (instance == null)
            instance = new CsvDao();
        return instance;
    }

    public List<GeoReferenced> getData(VisualQuery params) {
         List<GeoReferenced> results = new ArrayList<GeoReferenced>();
        try {

                CsvReader educacion = new CsvReader(this.getClass().getResource("/memoria/resources/data/educacion/educacion.csv").getPath());
                educacion.readHeaders();
                while (educacion.readRecord())
                {
                    String id = educacion.get("id");
                    Double longitud = Double.parseDouble(educacion.get("longitud"));
                    Double latitud = Double.parseDouble(educacion.get("latitud"));
                    String nombre = educacion.get("nombre");
                    String descripcion = educacion.get("descripcion");

                    LatLonCoordinate coordenadas = new LatLonCoordinate(latitud, longitud);
                    Point pi = new Point(Long.parseLong(id), coordenadas);
                    Escuela entidad = new Escuela(pi,nombre, descripcion);
                    results.add(entidad);

                }

                educacion.close();

        } catch (FileNotFoundException e) {
                e.printStackTrace();
        } catch (IOException e) {
                e.printStackTrace();
        }


        if ( params.getFiltro() != null)
            return params.getFiltro().filter(results);
        return results;
    }

}
