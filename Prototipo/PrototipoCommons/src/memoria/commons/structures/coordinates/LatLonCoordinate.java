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

    public double getLatitude(){
        return Double.parseDouble(this.getY());
    }

     public double getLongitude(){
        return Double.parseDouble(this.getX());
    }

    public LatLonCoordinate(String latitude, String longitude) {
        this.setX(longitude);
        this.setY(latitude);
    }

    public LatLonCoordinate(Double latitude, Double longitude) {
        this.setX(longitude.toString());
        this.setY(latitude.toString());
    }

    public LatLonCoordinate(Double latitude, Double longitude, Double altitude) {
        this.setX(longitude.toString());
        this.setY(latitude.toString());
        this.setZ(altitude.toString());
    }

    @Override
    public double to_double_x() {
        return getLongitude();
    }

    @Override
    public double to_double_y() {
        return getLatitude();
    }

    @Override
    public double to_double_z() {
        return Double.parseDouble(this.getZ());
    }







}
