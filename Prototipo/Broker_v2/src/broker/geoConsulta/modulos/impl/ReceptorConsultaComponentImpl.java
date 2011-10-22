package broker.geoConsulta.modulos.impl;

import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Service;

import broker.geoConsulta.modulos.AnalizadorConsultaComponent;
import broker.geoConsulta.modulos.ReceptorConsultaComponent;

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
			return e.getMessage();
		}
		return resultado;
	}
	
	@Reference
	public void setAnalizadorConsulta(
			AnalizadorConsultaComponent analizadorConsulta){
		this.analizadorConsulta = analizadorConsulta;
	}
}