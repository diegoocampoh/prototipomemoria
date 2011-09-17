/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.dataAccess;

import java.util.ArrayList;
import java.util.List;
import memoria.commons.structures.GeoReferenced;

/**
 *
 * @author diego
 */
public class SpatialDTO {

    private List<GeoReferenced> geoReferencedData = new ArrayList<GeoReferenced>();

    public SpatialDTO() {
    }

    public List<GeoReferenced> getGeoReferencedData() {
        return geoReferencedData;
    }

    public void setGeoReferencedData(List<GeoReferenced> geoReferencedData) {
        this.geoReferencedData = geoReferencedData;
    }

    public void addGeoReferencedObject(GeoReferenced spatialObject){
        this.geoReferencedData.add(spatialObject);
    }

    public void removeGeoReferencedObject(GeoReferenced spatialObject){
        this.geoReferencedData.remove(spatialObject);
    }



}
