package broker.geoConsulta.entidades;

import java.util.List;

/**
 * @author flor
 *
 */
public class Consulta {
	private int filtro;
	private List<Capa> entidades;
	public int getFiltro() {
		return filtro;
	}
	public void setFiltro(int filtro) {
		this.filtro = filtro;
	}
	public List<Capa> getEntidades() {
		return entidades;
	}
	public void setEntidades(List<Capa> entidades) {
		this.entidades = entidades;
	}

}
