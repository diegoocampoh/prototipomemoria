package broker.geoConsulta.modulos.impl;

import broker.geoConsulta.modulos.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.XStream;
import memoria.commons.dataAccess.query.UserQuery;
import java.rmi.RemoteException;



import org.osoa.sca.annotations.*;

public class AnalizadorConsultaComponentImp implements
		AnalizadorConsultaComponent{
	
	private EjecutorConsultaComponent ejecutorConsulta;
	
	public String interpretarConsulta(String xml){
		XStream xstream = new XStream(new DomDriver());
		String answer = "";
        UserQuery query = (UserQuery) xstream.fromXML(xml);
        	
        answer = this.ejecutorConsulta.ejecutarConsulta(query);
        return answer;
	}
	
	@Reference
	public void setEjecutorConsulta(
			EjecutorConsultaComponent ejecutorConsulta){
		this.ejecutorConsulta = ejecutorConsulta;
	}

}

