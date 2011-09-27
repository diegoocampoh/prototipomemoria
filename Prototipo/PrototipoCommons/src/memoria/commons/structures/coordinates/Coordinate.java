/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.structures.coordinates;

/**
 *
 * @author diego
 */
public abstract class Coordinate{

    private String x;
    private String y;
    private String z;

    public Coordinate(String x, String y) {
        this.x = x;
        this.y = y;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public Coordinate() {
    }

    public String getZ() {
        return z;
    }

    public void setZ(String z) {
        this.z = z;
    }

    

    public abstract double to_double_x();
    public abstract double to_double_y();
    public abstract double to_double_z();



}
