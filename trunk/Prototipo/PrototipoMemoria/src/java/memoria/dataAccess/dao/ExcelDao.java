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
import java.util.logging.Level;
import java.util.logging.Logger;
import jxl.*;
import jxl.read.biff.BiffException;
import memoria.commons.dataAccess.query.QueryParams;
import memoria.commons.dataAccess.query.VisualQuery;
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

    public List<GeoReferenced> getData(VisualQuery params) {
        try {
            Workbook workbook = Workbook.getWorkbook(new File(this.getClass().getResource("/memoria/resources/industri.xls").getPath()));
            Sheet sheet = workbook.getSheet(0);
            List<GeoReferenced> results = new ArrayList<GeoReferenced>();
            for(int i = 1; i <503; i++){
                Cell ai = sheet.getCell(0,i);
                Cell bi = sheet.getCell(1,i);
                Cell ci = sheet.getCell(2,i);
                LatLonCoordinate coordenadas = new LatLonCoordinate(bi.getContents(), ci.getContents());
                double[]latlong = CoordinateConversion.utm2LatLon("21 A "+  bi.getContents() + " " + ci.getContents());
                System.out.println(latlong[0]+";"+latlong[1]);
                Point pi = new Point(Long.parseLong(ai.getContents()), coordenadas);
                Escuela escuela = new Escuela(pi);
                results.add(escuela);
            }
            return params.getFiltro().filter(results);
        } catch (IOException ex) {
            Logger.getLogger(ExcelDao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BiffException ex) {
            Logger.getLogger(ExcelDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
