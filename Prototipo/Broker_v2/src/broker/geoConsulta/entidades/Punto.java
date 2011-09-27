package broker.geoConsulta.entidades;

public class Punto implements GeoRepresentation{
	private int latitud;
	private int longitud;
	public int getLatitud() {
		return latitud;
	}
	public void setLatitud(int latitud) {
		this.latitud = latitud;
	}
	public int getLongitud() {
		return longitud;
	}
	public void setLongitud(int longitud) {
		this.longitud = longitud;
	}
}
