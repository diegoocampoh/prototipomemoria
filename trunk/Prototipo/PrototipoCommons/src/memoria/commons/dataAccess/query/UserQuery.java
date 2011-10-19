package memoria.commons.dataAccess.query;

import java.util.ArrayList;
import java.util.List;

import memoria.commons.dataAccess.query.filtro.GisFilter;
import memoria.commons.xml.XmlSerializable;

public class UserQuery  extends XmlSerializable {
	//Representa las capas que el individuo desea visulaizar. 
	//El orden en que se ingresan en la lista es el orden en que lo quiere ver el usuario 
	private List<String> capas = new ArrayList<String>();
    private GisFilter filtro;

    public List<String> getCapas() {
        return capas;
    }

    public void setCapas(List<String> capas) {
        this.capas = capas;
    }

    public GisFilter getFiltro() {
        return filtro;
    }

    public void setFiltro(GisFilter filtro) {
        this.filtro = filtro;
    }

    public UserQuery(List<String> capas) {
        super();
        this.capas = capas;
    }
    public UserQuery() {
    	super();
    }

    public UserQuery(List<String> capas, GisFilter filtro) {
        super();
        this.capas = capas;
        this.filtro = filtro;
    }
    
    public void addCapa(String capa){
    	this.capas.add(capa);
    }

    

}
