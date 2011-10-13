package broker.geoConsulta.modulos.impl;

import broker.geoConsulta.entidades.Consulta;
import broker.geoConsulta.modulos.*;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.XStream;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.structures.GeoReferenced;
import java.util.List;



import org.osoa.sca.annotations.*;

public class AnalizadorConsultaComponentImp implements
		AnalizadorConsultaComponent{
	
	private EjecutorConsultaComponent ejecutorConsulta;
	
	public String interpretarConsulta(String xml){
		XStream xstream = new XStream(new DomDriver());
        try {
            VisualQuery query = (VisualQuery) xstream.fromXML(params);
            //hago lo que quiera con la consulta
            //RepositoriesManager repoManager = new RepositoriesManager();
            List<GeoReferenced> results = repoManager.getData(query);
            return xstream.toXML(results);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
		return this.ejecutorConsulta.ejecutarConsulta(xml);
	}
	
	@Reference
	public void setEjecutorConsulta(
			EjecutorConsultaComponent ejecutorConsulta){
		this.ejecutorConsulta = ejecutorConsulta;
	}

}

