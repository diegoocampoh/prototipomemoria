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
   public class Escuela extends EntidadPunto{

    public Escuela(Point location, String nombre, String descripcion) {
        super(nombre, descripcion, location);
    }

    @Override
    public String getIconName() {
        return "iconEscuela";
    }

}
