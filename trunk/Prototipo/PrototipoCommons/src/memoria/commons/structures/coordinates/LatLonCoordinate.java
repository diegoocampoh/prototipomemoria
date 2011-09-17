/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.structures.coordinates;

/**
 *
 * @author diego
 */
public class LatLonCoordinate extends Coordinate{

    public LatLonCoordinate(String latitude, String longitude) {
        this.setX(longitude);
        this.setY(latitude);
    }

    public LatLonCoordinate(Double latitude, Double longitude) {
        this.setX(longitude.toString());
        this.setY(latitude.toString());
    }

}
