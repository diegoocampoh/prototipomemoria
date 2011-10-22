package broker.geoConsulta.modulos.impl;

import memoria.commons.dataAccess.query.UserQuery;

import org.osoa.sca.annotations.Reference;

import broker.geoConsulta.modulos.AnalizadorConsultaComponent;
import broker.geoConsulta.modulos.EjecutorConsultaComponent;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

public class AnalizadorConsultaComponentImp implements
		AnalizadorConsultaComponent{
	
	private EjecutorConsultaComponent ejecutorConsulta;
	
	public String interpretarConsulta(String xml){
		System.out.println("Entra a AnalizadorConsultaComponentImp.interpretarConsulta");
		XStream xstream = new XStream(new DomDriver());
		UserQuery query = (UserQuery) xstream.fromXML(xml);
	    String answer = this.ejecutorConsulta.ejecutarConsulta(query);
        return answer;
	}
	
	@Reference
	public void setEjecutorConsulta(
			EjecutorConsultaComponent ejecutorConsulta){
		this.ejecutorConsulta = ejecutorConsulta;
	}

}

