/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.structures;

import java.util.List;

/**
 *
 * @author diego
 */
public abstract class AbstractGeographicElement  {

    public abstract List<Point> getPoints();
    public abstract List<Point> getCenterPoints();
    public abstract String getTypeRepresentation();

}
