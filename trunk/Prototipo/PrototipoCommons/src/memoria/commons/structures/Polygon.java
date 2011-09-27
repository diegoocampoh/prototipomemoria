/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author diego
 */
public class Polygon extends Line {

    private Point center;

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public Polygon(Point center) {
        super();
        this.center = center;
    }

    public Polygon(){
        super();
    }

    @Override
    public List<Point> getCenterPoints() {
        return Arrays.asList(this.getCenter());
    }

}
