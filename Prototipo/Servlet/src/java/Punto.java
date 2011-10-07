/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Fran
 */
public class Punto implements ElemGeograf {
    private Coordenadas coord;
    private String descr;

    public String getDescr()
    {
        return this.descr;
    }

    public Punto(Coordenadas unaCoordenada)
    {
        
        coord = unaCoordenada;
    }


    public String ToKml(int nivel)
    {
        String result =  "<Placemark>\n\t <Point>\n\t <coordinates> "+this.coord.ToKml()
                +"</coordinates>\n </Point> \n </Placemark> \n";

        return result;
    }
    

}
