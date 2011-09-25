/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.dataAccess.dao;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import memoria.commons.dataAccess.query.QueryParams;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.structures.GeoReferenced;
import memoria.dataAccess.IRepositoryDao;
import memoria.dataAccess.SpatialDTO;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.opengis.feature.simple.SimpleFeature;

/**
 *
 * @author diego
 */
public class ShapeFileDao implements IRepositoryDao {

    //Patron Singleton
    private static ShapeFileDao instance;
    public static IRepositoryDao getInstance(){
        if (instance == null)
            instance = new ShapeFileDao();
        return instance;
    }

    public List<GeoReferenced> getData(VisualQuery params) {

        try{
            ShapefileDataStore shp = new ShapefileDataStore(new URL("file://"+this.getClass().getResource("/memoria/resources/data/comisarias/comisarias_reprojected.shp").getPath()));
            
            int attributeCount = shp.getFeatureSource().getFeatures().getSchema().getAttributeCount();
            SimpleFeatureCollection col = shp.getFeatureSource().getFeatures();
            col.toArray();
            System.out.println(( (SimpleFeature) col.toArray()[0]).getProperties());
        } catch (Exception ex) {
            Logger.getLogger(ShapeFileDao.class.getName()).log(Level.SEVERE, null, ex);
        } 
        return new ArrayList<GeoReferenced>();
    }


}
