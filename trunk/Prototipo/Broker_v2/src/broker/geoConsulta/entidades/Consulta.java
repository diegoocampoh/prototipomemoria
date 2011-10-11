package broker.geoConsulta.entidades;

import java.util.List;

/**
 * @author flor
 *
 */
public class Consulta {
	//Propert
	
	private List<Capa> entidades;
	
	public List<Capa> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<Capa> entidades) {
		this.entidades = entidades;
	}
	
	private iFilter filtro;
	public iFilter getFiltro()
	{
		return filtro;
	}
	public void getFiltro(iFilter _filtro)
	{
		filtro = _filtro;
	}
}
