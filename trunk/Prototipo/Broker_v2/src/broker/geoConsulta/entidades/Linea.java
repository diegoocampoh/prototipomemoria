package broker.geoConsulta.entidades;

public class Linea implements GeoRepresentation {
	private Punto punto1;
	private Punto punto2;
	public Punto getPunto1() {
		return punto1;
	}
	public void setPunto1(Punto punto1) {
		this.punto1 = punto1;
	}
	public Punto getPunto2() {
		return punto2;
	}
	public void setPunto2(Punto punto2) {
		this.punto2 = punto2;
	}
}
