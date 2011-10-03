/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.structures;

import memoria.commons.structures.coordinates.Coordinate;

/**
 *
 * @author Fran
 */
public class WMSConsult {
    private Coordinate SW;
    private Coordinate NE;
    private Coordinate Centro;
    private String[] Capas;

    public Coordinate getSW()
    {
        return this.SW;
    }
    public Coordinate getNE()
    {
        return this.NE;
    }

    public Coordinate getCentro()
    {
        return this.Centro;
    }

    public String[] getCapas()
    {
        return this.Capas;
    }
    public void setSW(Coordinate unSW)
    {
        this.SW = unSW;
    }
    public void setNE(Coordinate unNE)
    {
        this.NE = unNE;
    }
    public void setCentro(Coordinate unCentro)
    {
        this.Centro = unCentro;
    }
    public void setCapas(String[] unaCapas)
    {
        this.Capas = unaCapas;
    }





}
