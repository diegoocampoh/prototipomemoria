package broker.geoConsulta.modulos.impl;

import broker.geoConsulta.entidades.Consulta;
import broker.geoConsulta.modulos.*;

import org.osoa.sca.annotations.*;

public class AnalizadorConsultaComponentImp implements
		AnalizadorConsultaComponent{
	
	private EjecutorConsultaComponent ejecutorConsulta;
	
	public String interpretarConsulta(String xml){
		
		return this.ejecutorConsulta.ejecutarConsulta(xml);
	}
	
	@Reference
	public void setEjecutorConsulta(
			EjecutorConsultaComponent ejecutorConsulta){
		this.ejecutorConsulta = ejecutorConsulta;
	}

}

