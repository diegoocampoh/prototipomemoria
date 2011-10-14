package broker.geoConsulta.modulos.impl;

import broker.geoConsulta.modulos.*;

import org.osoa.sca.annotations.*;

@Service(ReceptorConsultaComponent.class)
public class ReceptorConsultaComponentImpl implements
		ReceptorConsultaComponent{
	private AnalizadorConsultaComponent analizadorConsulta;
	
	public String obtenerGeoInfo(String consultaXml){
		System.out.println("Nuevo mensaje a Broker. Consulta: " + consultaXml);
		String resultado = "";
		try{
			resultado = this.analizadorConsulta.interpretarConsulta(consultaXml);
		}catch(Exception e){
			return "Error Interno en Broker: " + e.getMessage();
		}
		return resultado;
	}
	
	@Reference
	public void setAnalizadorConsulta(
			AnalizadorConsultaComponent analizadorConsulta){
		this.analizadorConsulta = analizadorConsulta;
	}
}