/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran
 */
public class Coordenadas {

    private double longitude;
    private double latitude;



    public Coordenadas(double lat, double longi)
    {
        this.latitude = lat;
        this.longitude = longi;
    }
    public String ToKml()
    {
        return longitude + "," + latitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }



}
