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
public class MultiPolygon extends AbstractGeographicElement {

    private Polygon outerRing;
    private List<Polygon> poligonos = new ArrayList<Polygon>();

    public List<Polygon> getLineas() {
        return poligonos;
    }

    public void setLineas(List<Polygon> lineas) {
        this.poligonos = lineas;
    }

    public MultiPolygon(Polygon outerRing) {
        this.setOuterRing(outerRing);
    }

    @Override
    public List<Point> getCenterPoints(){
        return outerRing.getCenterPoints();
    }

    @Override
    public List<Point> getPoints() {
        List<Point> results = new ArrayList<Point>();
        for(Polygon pols : poligonos){
            results.addAll(pols.getPoints());
        }
        results.addAll(this.outerRing.getPoints());
        return results;
    }

    public List<Polygon> getPoligonos() {
        return poligonos;
    }

    public void setPoligonos(List<Polygon> poligonos) {
        this.poligonos = poligonos;
    }

    public Polygon getOuterRing() {
        return outerRing;
    }

    public void setOuterRing(Polygon outerRing) {
        this.outerRing = outerRing;
    }





    

}
