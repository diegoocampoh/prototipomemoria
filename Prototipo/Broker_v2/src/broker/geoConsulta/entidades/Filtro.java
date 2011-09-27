package broker.geoConsulta.entidades;


public class Filtro {
	private Coordenada downLeftCorner;
	private Coordenada upRightCorner;
	public Coordenada getDownLeft() {
		return downLeftCorner;
	}
	public void setDownLeft(Coordenada downLeftCorner) {
		this.downLeftCorner = downLeftCorner;
	}
	public Coordenada getUpRight() {
		return upRightCorner;
	}
	public void setUpRight(Coordenada upRightCorner) {
		this.upRightCorner = upRightCorner;
	}
}
