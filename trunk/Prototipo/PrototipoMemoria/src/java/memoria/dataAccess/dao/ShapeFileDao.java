/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package memoria.dataAccess.dao;

import com.vividsolutions.jts.geom.Coordinate;
import com.vividsolutions.jts.geom.Geometry;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import memoria.commons.dataAccess.query.QueryParams;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.entities.EntidadLinea;
import memoria.commons.entities.EntidadPoligono;
import memoria.commons.entities.EntidadPunto;
import memoria.commons.entities.Municipio;
import memoria.commons.structures.GeoReferenced;
import memoria.commons.structures.Line;
import memoria.commons.structures.MultiPolygon;
import memoria.commons.structures.Point;
import memoria.commons.structures.Polygon;
import memoria.commons.structures.coordinates.LatLonCoordinate;
import memoria.dataAccess.IRepositoryDao;
import memoria.dataAccess.SpatialDTO;
import org.geotools.data.shapefile.ShapefileDataStore;
import org.geotools.data.shapefile.ShapefileDataStoreFactory;
import org.geotools.data.simple.SimpleFeatureCollection;
import org.geotools.data.simple.SimpleFeatureIterator;
import org.opengis.feature.simple.SimpleFeature;

/**
 *
 * @author diego
 */
public class ShapeFileDao implements IRepositoryDao {

    //Patron Singleton
    private static ShapeFileDao instance;

    public static IRepositoryDao getInstance() {
        if (instance == null) {
            instance = new ShapeFileDao();
        }
        return instance;
    }

    private String fileUrl;

    public List<GeoReferenced> getData(VisualQuery params) {
        List<GeoReferenced> results = new ArrayList<GeoReferenced>();
        try {
            //ShapefileDataStore shp = new ShapefileDataStore(new URL("file://"+this.getClass().getResource("/memoria/resources/data/comisarias/comisarias_reprojected.shp").getPath()));
            ShapefileDataStore shp = new ShapefileDataStore(new URL("file://" + this.fileUrl));
            SimpleFeatureCollection col = shp.getFeatureSource().getFeatures();
            SimpleFeatureIterator iterator = col.features();
            try {
                while (iterator.hasNext()) {
                    SimpleFeature feature = iterator.next();
                    try {
                        results.add(instanciarEntidad(feature));
                    } catch (Exception e) {
                        Logger.getLogger(ShapeFileDao.class.getName()).log(Level.SEVERE, "Error al instanciar entidad del shapefile", e);
                    }
                }
            } finally {
                iterator.close(); // IMPORTANT
            }

        } catch (Exception ex) {
            Logger.getLogger(ShapeFileDao.class.getName()).log(Level.SEVERE, "Error al leer ShapeFile", ex);
        }
        if (params.getFiltro() != null) {
            return params.getFiltro().filter(results);
        }
        return results;
    }

    public GeoReferenced instanciarEntidad(SimpleFeature feature) {
        Geometry geom = (Geometry) feature.getDefaultGeometry();
        GeoReferenced entidad = null;
        if (geom.getGeometryType().equals("Point")) {
            LatLonCoordinate coordenadas = new LatLonCoordinate(geom.getCoordinate().y, geom.getCoordinate().x);
            Point punto = new Point(coordenadas);
            entidad = new EntidadPunto(feature.getAttribute(1).toString(), feature.getAttribute(2).toString(), punto);
        }
        if (geom.getGeometryType().equals("Polygon")) {
            for (Coordinate coordenada : geom.getCoordinates()) {
                LatLonCoordinate coordenadas = new LatLonCoordinate(coordenada.y, coordenada.x, coordenada.z);
                Point punto = new Point(coordenadas);
                entidad = new EntidadPunto(feature.getAttribute(1).toString(), feature.getAttribute(2).toString(), punto);
            }
        }
        if (geom.getGeometryType().equals("MultiLineString")) {
            Line line = new Line();
            line.setCenter(new Point(new LatLonCoordinate(geom.getCentroid().getCoordinate().y, geom.getCentroid().getCoordinate().x)));
            for (Coordinate coordenada : geom.getCoordinates()) {
                LatLonCoordinate coordenadas = new LatLonCoordinate(coordenada.y, coordenada.x, coordenada.z);
                Point punto = new Point(coordenadas);
                line.getPoints().add(punto);                
            }
            entidad = new EntidadLinea(feature.getAttribute(1).toString(), "", line);
        }

        
        if (geom.getGeometryType().equals("MultiPolygon")) {
            MultiPolygon multiPolygon = new MultiPolygon(null);
            int numberOfGeometries = geom.getNumGeometries();
            for (int i = 0; i < numberOfGeometries; i++) {
                Geometry geomN = geom.getGeometryN(i);
                if (geomN.getGeometryType().equals("Polygon")) {
                   Polygon polygon = new Polygon(new Point(new LatLonCoordinate(geomN.getCentroid().getY(),geomN.getCentroid().getX())));
                    for (Coordinate coordenada : geomN.getCoordinates()) {
                        LatLonCoordinate coordenadas = new LatLonCoordinate(coordenada.y, coordenada.x, coordenada.z);
                        Point punto = new Point(coordenadas);
                        polygon.getPoints().add(punto);
                    }
                    multiPolygon.getPoligonos().add(polygon);
                }
            }
            EntidadPoligono entidadPoligono = new EntidadPoligono();
            entidadPoligono.setLocation(multiPolygon.getPoligonos().get(0));
            entidadPoligono.setNombre(feature.getAttribute(1).toString());
            entidadPoligono.setDescripcion(feature.getAttribute(2).toString());
            entidad = entidadPoligono;
            
        }
    return entidad ;
}

    public void setInitParams(Map<String, String> params) {
        this.fileUrl = params.get("URL");
    }

}
