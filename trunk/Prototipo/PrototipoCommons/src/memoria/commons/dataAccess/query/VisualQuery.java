/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.dataAccess.query;

import memoria.commons.dataAccess.query.filtro.GisFilter;
import memoria.commons.xml.XmlSerializable;


public class VisualQuery extends XmlSerializable{
    
    private String capa;
    private GisFilter filtro;

    public String getCapa() {
        return capa;
    }

    public void setCapa(String capa) {
        this.capa = capa;
    }

    public GisFilter getFiltro() {
        return filtro;
    }

    public void setFiltro(GisFilter filtro) {
        this.filtro = filtro;
    }

    public VisualQuery(String capa) {
        super();
        this.capa = capa;
    }

    public VisualQuery(String capa, GisFilter filtro) {
        super();
        this.capa = capa;
        this.filtro = filtro;
    }

    

}
