/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.entities;

import memoria.commons.structures.AbstractGeographicElement;
import memoria.commons.structures.GeoReferenced;
import memoria.commons.structures.MultiPolygon;
import memoria.commons.structures.Polygon;

/**
 *
 * @author diego
 */
public class EntidadPoligono extends GeoReferenced<Polygon> {

    private String nombre;
    private String descripcion;
    private Polygon location;


    @Override
    public Polygon getSpatialRepresentation() {
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

    public Polygon getLocation() {
        return location;
    }

    public void setLocation(Polygon location) {
        this.location = location;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }




}
