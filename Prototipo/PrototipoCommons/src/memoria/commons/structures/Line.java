/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.structures;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author diego
 */
public class Line extends AbstractGeographicElement {

    private List<Point> points = new ArrayList<Point>();

    public Line() {
    }

    public List<Point> getPoints() {
        return points;
    }

    public void setPoints(List<Point> points) {
        this.points = points;
    }

    @Override
    public List<Point> getCenterPoints() {
        return getPoints();
    }



   
}