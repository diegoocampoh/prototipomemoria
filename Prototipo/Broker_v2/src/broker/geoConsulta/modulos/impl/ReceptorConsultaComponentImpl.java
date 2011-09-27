package broker.geoConsulta.modulos.impl;

import broker.geoConsulta.modulos.*;

import org.osoa.sca.annotations.*;

@Service(ReceptorConsultaComponent.class)
public class ReceptorConsultaComponentImpl implements
		ReceptorConsultaComponent{
	private AnalizadorConsultaComponent analizadorConsulta;
	
	public String obtenerGeoInfo(String consultaXml){
		return this.analizadorConsulta.interpretarConsulta(consultaXml);
	}
	
	@Reference
	public void setAnalizadorConsulta(
			AnalizadorConsultaComponent analizadorConsulta){
		this.analizadorConsulta = analizadorConsulta;
	}
}