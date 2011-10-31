package broker.tools;

import memoria.commons.structures.GeoReferenced;

public class GeoDato {
	private GeoReferenced objeto;
	private String capa;
	public GeoDato(GeoReferenced _objeto, String _capa){
		this.objeto = _objeto;
		this.capa = _capa;
	}
	public GeoReferenced getObjeto() {
		return objeto;
	}
	public void setObjeto(GeoReferenced objeto) {
		this.objeto = objeto;
	}
	public String getCapa() {
		return capa;
	}
	public void setCapa(String capa) {
		this.capa = capa;
	}
	

}
