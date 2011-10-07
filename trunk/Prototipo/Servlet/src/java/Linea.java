
import java.util.ArrayList;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran
 */
public class Linea implements ElemGeograf {

    private ArrayList<Coordenadas> coord = new ArrayList<Coordenadas>();
    private String descr;

    public String getDescr()
    {
        return descr;
    }

    public Linea(ArrayList<Coordenadas> unasCoord)
    {
        this.coord = unasCoord;
    }

    public String ToKml(int nivel)
    {
        String result = "<Placemark> \n <LineString>\n <coordinates>\n";
        for (Coordenadas c: coord)
        {
            result = result + c.ToKml() + "\n";
        }
        result = result + "</coordinates>\n </LineString> \n </Placemark> \n";
        return result;
    }


}
