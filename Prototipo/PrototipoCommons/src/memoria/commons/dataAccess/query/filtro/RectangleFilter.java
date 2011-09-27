/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.dataAccess.query.filtro;

import java.util.ArrayList;
import java.util.List;
import memoria.commons.structures.AbstractGeographicElement;
import memoria.commons.structures.GeoReferenced;
import memoria.commons.structures.Point;

/**
 *
 * @author diego
 */
public class RectangleFilter extends GisFilter {

    private  Point southWest;
    private  Point northEast;

    public Point getNorthEast() {
        return northEast;
    }

    public void setNorthEast(Point northEast) {
        this.northEast = northEast;
    }

    public Point getSouthWest() {
        return southWest;
    }

    public void setSouthWest(Point southWest) {
        this.southWest = southWest;
    }

    public RectangleFilter() {

    }

    public RectangleFilter(Point southWest, Point northEast) {
        this.southWest = southWest;
        this.northEast = northEast;
    }

    @Override
    public List<GeoReferenced> filter(List<GeoReferenced> data) {
        List<GeoReferenced> results = new ArrayList<GeoReferenced>();

        for (GeoReferenced geoReferenced : data) {
            List<Point> puntos = geoReferenced.getSpatialRepresentation().getCenterPoints();
            for (Point p : puntos){
                if((p.getCoordiante().to_double_x() >= this.southWest.getCoordiante().to_double_x() &&
                       (p.getCoordiante().to_double_x() <= this.northEast.getCoordiante().to_double_x()) &&
                       (p.getCoordiante().to_double_y() >= this.southWest.getCoordiante().to_double_y()) &&
                       (p.getCoordiante().to_double_y() <= this.northEast.getCoordiante().to_double_y()))){
                    results.add(geoReferenced);
                }
            }
        }


        return results;
    }
}
