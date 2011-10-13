package broker.geoConsulta.modulos.impl;

import broker.geoConsulta.entidades.Consulta;
import broker.geoConsulta.modulos.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.XStream;
import memoria.commons.dataAccess.query.UserQuery;
import memoria.commons.structures.GeoReferenced;
import java.util.List;



import org.osoa.sca.annotations.*;

public class AnalizadorConsultaComponentImp implements
		AnalizadorConsultaComponent{
	
	private EjecutorConsultaComponent ejecutorConsulta;
	
	public String interpretarConsulta(String xml){
		XStream xstream = new XStream(new DomDriver());
		UserQuery query = null;
        try {
            query = (UserQuery) xstream.fromXML(xml);
        	} catch (Exception e) {
            e.printStackTrace();
        }
        return this.ejecutorConsulta.ejecutarConsulta(query);
	}
	
	@Reference
	public void setEjecutorConsulta(
			EjecutorConsultaComponent ejecutorConsulta){
		this.ejecutorConsulta = ejecutorConsulta;
	}

}

