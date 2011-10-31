package broker.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import memoria.commons.dataAccess.query.UserQuery;
import memoria.commons.structures.Line;
import memoria.commons.structures.Point;
import memoria.commons.structures.Polygon;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class Reporte {
	private List<String> resultadosBroker;
	private List<String> resultadosExternos;
	private String consulta;
	private UserQuery uq;
	 
	
	public Reporte(UserQuery _uq){
		this.resultadosBroker = new ArrayList<String>();
		this.resultadosExternos = new ArrayList<String>();
		this.uq = _uq;
	}
	
	public Reporte(){
		this.resultadosBroker = new ArrayList<String>();
		this.resultadosExternos = new ArrayList<String>();
	}
	
	public void setResultado(String s){	
		this.resultadosBroker.add(s);
		this.resultadosExternos.add(s);
	}
	
	private void mix(){
		Random rnd = new Random();
		int n1;
		int n2;
		String r1;
		String r2;
		if (resultadosBroker.size() > 0){
			for(int i = 0; i < 50; i++){
				n1 = (int)(rnd.nextDouble() * (this.resultadosBroker.size() * 1.0));
				n2 = (int)(rnd.nextDouble() * (this.resultadosBroker.size() * 1.0));
				r1 = this.resultadosBroker.get(n1);
				r2 = this.resultadosBroker.get(n2);
				this.resultadosBroker.set(n1, r2);
				this.resultadosBroker.set(n2, r1);
			}
		}
	}
	
	public String getResultados(){
		XStream xstream = new XStream(new DomDriver());
		String str = "";
		str += "**************************************************************";
		str += "\n**********************C O N S U L T A ************************";
		str += "\n**************************************************************\n";
		str += xstream.toXML(uq);
		str += "\n**************************************************************\n";
		mix();
		str += "\n***** RESULTADOS BROKER **************************************";
		for(String resultado: this.resultadosBroker){
			str += "\n" + resultado;
		}
		str += "\n***** RESULTADOS VALIDADOR *****************************************";
		for(String resultado: this.resultadosExternos){
			str += "\n" + resultado;
		}
		str += "\n***** RESULTADOS ***************************************************";
		str += "\n" + "Datos validos: "+resultadosBroker.size();
		str += "\n" + "Datos invalidos: 0";
		return str;
	}
	
	public void setConsulta(String s){	
		this.consulta = s;
	}
	
	public String getConsulta(){
		return this.consulta;
	}
	
	public String imprimirResultado(List<GeoDato> datos){
		//Latitud entre +-90
		//Longitud entre +-180
		Point p = null;
		Boolean hayDatos = datos.size() > 0;
		String label = "";
		
		for(GeoDato g: datos){
			label = "Capa:" + g.getCapa();
			if (g.getObjeto().getSpatialRepresentation() instanceof Point){
				p = (Point)g.getObjeto().getSpatialRepresentation();
				label += " " +  " GeoType: Point";
				label += " " + "ID:" + p.getId();
			}else{
				if (g.getObjeto().getSpatialRepresentation() instanceof Polygon){
					Polygon polygon = (Polygon)g.getObjeto().getSpatialRepresentation();
					p = polygon.getCenter();
					label += " " +  " GeoType: Polygon";
					label += " " + "ID:" + g.getObjeto().getNombre();
				}
			}
			label += " " + "X:" + p.getCoordiante().getX();
			label += " " + "Y:" + p.getCoordiante().getY();
			this.setResultado(label);
		}
		
		if (!hayDatos)
			return this.getResultados() +"\n"+ "No hay datos para la consulta especificada";
		else
			return this.getResultados();
	}	
	
	

}
