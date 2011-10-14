
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran
 */
public class Poligono implements ElemGeograf {

    private ArrayList<Coordenadas> coord;
    private String descr;

    public Poligono(ArrayList<Coordenadas> unasCoord)
    {
        this.coord = unasCoord;
        this.coord.add(unasCoord.get(0));
    }
    public String getDescr()
    {
        return this.descr;
    }

    public String ToKml(int nivel) {
        String result = "<Placemark> \n\t <Polygon> \n <outerBoundaryIs> <LinearRing>\n\t <coordinates>\n";
        for(Coordenadas cord:coord)
        {
            result = result + cord.ToKml() + "\n";
        }
        result = result + "</coordinates> \n </LinearRing> \n  </outerBoundaryIs> \n </Polygon> \n </Placemark>";
        return result;
    }



}
