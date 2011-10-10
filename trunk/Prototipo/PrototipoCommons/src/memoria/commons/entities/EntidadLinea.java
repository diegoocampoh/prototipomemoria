/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.entities;

import memoria.commons.structures.AbstractGeographicElement;
import memoria.commons.structures.GeoReferenced;
import memoria.commons.structures.Line;

/**
 *
 * @author diego
 */
public class EntidadLinea extends GeoReferenced<Line>
{

    private String nombre;
    private String descripcion;
    private Line location;

     public EntidadLinea(String nombre, String descripcion, Line location) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.location = location;
    }

    @Override
    public Line getSpatialRepresentation() {
        return location;
    }

    @Override
    public String getNombre() {
       return nombre;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public String getIconName() {
        return "";
    }

    public Line getLocation() {
        return location;
    }

    public void setLocation(Line location) {
        this.location = location;
    }

    

}
