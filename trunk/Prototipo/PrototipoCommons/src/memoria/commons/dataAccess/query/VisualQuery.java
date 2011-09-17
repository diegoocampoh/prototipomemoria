/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.dataAccess.query;

import java.util.List;
import memoria.commons.structures.Point;
import memoria.commons.dataAccess.query.filtro.GisFilter;


public class VisualQuery {
    
    private String capas;
    private GisFilter filtro;

    public String getCapas() {
        return capas;
    }

    public void setCapas(String capas) {
        this.capas = capas;
    }

    public GisFilter getFiltro() {
        return filtro;
    }

    public void setFiltro(GisFilter filtro) {
        this.filtro = filtro;
    }

    public VisualQuery(String capas) {
        this.capas = capas;
    }

    public VisualQuery(String capas, GisFilter filtro) {
        this.capas = capas;
        this.filtro = filtro;
    }

    

}
