package broker.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import memoria.commons.structures.Point;
import memoria.commons.structures.Polygon;

public class Simulador {
	String[] entidades = {"Comisarias","Municipios","Industrias","Ciclovias","Escuelas"};
	private List<Double> doublesLonX;
	private List<Double> doublesLatY;
	
	public Simulador(){
		this.doublesLonX = new ArrayList<Double>();
		this.doublesLatY = new ArrayList<Double>();
	}
	
	public List<String> ObtenerEntidades(){
		List<String> resultados = new ArrayList<String>();
		Random rnd = new Random();
		int n1 = (int)(rnd.nextDouble() * 5.0);
		int n2;
		//-34.73896585889872
		//-34.92221929108825
		for (int i = 0; i<n1; i++){
			n2 = (int)(rnd.nextDouble() * 5.0);
			while(resultados.contains(entidades[n2])){
				n2 = (int)(rnd.nextDouble() * 5.0);
			}
			resultados.add(entidades[n2]);
		}
		
		return resultados;
		
	}
	
	public List<Double> ObtenerCoordenadas(List<Double> latitudes, List<Double> longitudes){
		//Latitud entre +-90
		//Longitud entre +-180
		Random rnd = new Random();
		List<Double> resultados = new ArrayList<Double>();
		double lat1 = latitudes.get((int)(latitudes.size()*rnd.nextDouble()));
		double lat2 = latitudes.get((int)(latitudes.size()*rnd.nextDouble()));
		double lon1 = longitudes.get((int)(longitudes.size()*rnd.nextDouble()));
		double lon2 = longitudes.get((int)(longitudes.size()*rnd.nextDouble()));
		if (lat1 < lat2){
			resultados.add(lat1);
			resultados.add(lat2);
		}
		else{
			resultados.add(lat2);
			resultados.add(lat1);
		}
		
		if (lon1 < lon2){
			resultados.add(lon1);
			resultados.add(lon2);
		}
		else{
			resultados.add(lon2);
			resultados.add(lon1);
		}
		
		
		return resultados;
	}
	
	private void CargarCoordenadas(List<GeoDato> datos){
		//Latitud entre +-90
		//Longitud entre +-180
		Point p = null;
		Boolean hayDatos = datos.size() > 0;
		String label = "";
		
		for(GeoDato g: datos){
			if (g.getObjeto().getSpatialRepresentation() instanceof Point){
				p = (Point)g.getObjeto().getSpatialRepresentation();
			}else{
				if (g.getObjeto().getSpatialRepresentation() instanceof Polygon){
					Polygon polygon = (Polygon)g.getObjeto().getSpatialRepresentation();
					p = polygon.getCenter();
				}
			}
			this.doublesLonX.add(Double.parseDouble(p.getCoordiante().getX()));
			this.doublesLatY.add(Double.parseDouble(p.getCoordiante().getY()));
			
		}
	}
	
	public List<Double> getLongitudes(List<GeoDato> datos){
		if (doublesLonX.size() == 0)
			CargarCoordenadas(datos);
		return this.doublesLonX;
	}
	
	public List<Double> getLatitudes(List<GeoDato> datos){
		if (doublesLatY.size() == 0)
			CargarCoordenadas(datos);
		return this.doublesLatY;
	}
}
