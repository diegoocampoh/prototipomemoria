/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.dataAccess.dao;

import java.io.IOException;
import java.util.List;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.*;
import jxl.read.biff.BiffException;
import memoria.commons.dataAccess.query.QueryParams;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.entities.EntidadPunto;
import memoria.commons.entities.Escuela;
import memoria.commons.structures.AbstractGeographicElement;
import memoria.commons.structures.coordinates.Coordinate;
import memoria.commons.structures.GeoReferenced;
import memoria.commons.structures.Point;
import memoria.commons.structures.coordinates.LatLonCoordinate;
import memoria.dataAccess.IRepositoryDao;
import memoria.dataAccess.SpatialDTO;
import memoria.utils.coordinate.*;

/**
 *
 * @author diego
 */
public class ExcelDao implements IRepositoryDao {

    //Patron Singleton
    private static ExcelDao instance;
    public static IRepositoryDao getInstance(){
        if (instance == null)
            instance = new ExcelDao();
        return instance;
    }

    private String fileUrl;

    public List<GeoReferenced> getData(VisualQuery params) {
        try {
            Workbook workbook = Workbook.getWorkbook(new File(fileUrl));
            Sheet sheet = workbook.getSheet(0);
            List<GeoReferenced> results = new ArrayList<GeoReferenced>();

            for(int i = 1; i <sheet.getRows(); i++){

                EntidadPunto entidadPunto = null;
                try {
                    Cell id = sheet.getCell(0, i);
                    Cell lat = sheet.getCell(1, i);
                    Cell lon = sheet.getCell(2, i);
                    String nombre = "";
                    try {
                        nombre = sheet.getCell(3, i).getContents();
                    } catch (Exception e) {
                         //Logger.getLogger(ExcelDao.class.getName()).log(Level.SEVERE, "Error al leer nombre", e);
                    }
                    String descripcion = "";
                    try {
                        descripcion = sheet.getCell(4, i).getContents();
                    } catch (Exception e) {
                         //Logger.getLogger(ExcelDao.class.getName()).log(Level.SEVERE, "Error al leer descripcion", e);
                    }
                    double[] latlong = CoordinateConversion.utm2LatLon("21 A " + lat.getContents() + " " + lon.getContents());
                    LatLonCoordinate coordenadas = new LatLonCoordinate(latlong[0], latlong[1]);
                    //System.out.println(latlong[0]+";"+latlong[1]);
                    Point pi = new Point(Long.parseLong(id.getContents()), coordenadas);
                    entidadPunto = new EntidadPunto( nombre,  descripcion,pi);
                    results.add(entidadPunto);
                } catch (Exception e) {
                   Logger.getLogger(ExcelDao.class.getName()).log(Level.SEVERE, "Error al leer entidad", e);
                }
                
            }
            if ( params.getFiltro() != null)
                return params.getFiltro().filter(results);
            return results;
        } catch (IOException ex) {
            Logger.getLogger(ExcelDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(ExcelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public void setInitParams(Map<String, String> params) {
        this.fileUrl = params.get("URL");
    }

    
}
