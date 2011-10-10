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
public class Line extends AbstractGeographicElement {

    private List<Point> points = new ArrayList<Point>();
    private Point center;

    public Line() {
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public String getTypeRepresentation()
    {
        return "Line";
    }

    @Override
    public List<Point> getCenterPoints() {
        return Arrays.asList(center);
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }




   
}
