/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.entities;

import memoria.commons.structures.GeoReferenced;
import memoria.commons.structures.MultiPolygon;

/**
 *
 * @author diego
 */
public class Municipio  extends GeoReferenced<MultiPolygon> {

    private String nombre;
    private String descripcion;
    private MultiPolygon location;

    @Override
    public MultiPolygon getSpatialRepresentation() {
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

    public MultiPolygon getLocation() {
        return location;
    }

    public void setLocation(MultiPolygon location) {
        this.location = location;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    

}
