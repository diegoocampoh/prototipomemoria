/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.entities;

import memoria.commons.structures.GeoReferenced;
import memoria.commons.structures.Point;

/**
 *
 * @author diego
 */
public class EntidadPunto extends GeoReferenced<Point> {

    private String nombre;
    private String descripcion;
    private Point location;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Point getLocation() {
        return location;
    }

    public void setLocation(Point location) {
        this.location = location;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public Point getSpatialRepresentation() {
        return location;
    }

    public EntidadPunto(String nombre, String descripcion, Point location) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.location = location;
    }

    @Override
    public String getIconName() {
        return "iconPunto";
    }

    


}
