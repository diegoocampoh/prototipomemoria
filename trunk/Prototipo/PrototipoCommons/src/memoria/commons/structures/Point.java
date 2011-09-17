/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.structures;

import memoria.commons.structures.coordinates.Coordinate;

/**
 *
 * @author diego
 */
public class Point extends AbstractGeographicElement{

    private Long id;
    private Coordinate coordiante;

    public Coordinate getCoordiante() {
        return coordiante;
    }

    public void setCoordiante(Coordinate coordiante) {
        this.coordiante = coordiante;
    }

    public Point() {
    }

    public Point(Long id, Coordinate coordinate) {
        this.id = id;
        this.coordiante = coordinate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
