/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.entities;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import memoria.commons.structures.AbstractGeographicElement;
import memoria.commons.structures.GeoReferenced;
import memoria.commons.structures.Point;

/**
 *
 * @author diego
 */
public class Escuela extends GeoReferenced<Point>{

    private String nombre;
    private Point location;

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public Escuela(Point location) {
        this.location = location;
        this.nombre = "fruta";
    }


    @XmlElement(name = "representation")
    public Point getSpatialRepresentation() {
        return this.location;
    }

}
