package broker.geoConsulta.modulos.impl;


import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import memoria.commons.dataAccess.query.UserQuery;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.structures.AbstractGeographicElement;
import memoria.commons.structures.GeoReferenced;
import broker.geoConsulta.modulos.*;
import memoria.ws.*;

public class EjecutorConsultaComponentImpl implements
		EjecutorConsultaComponent{
	
	
	public String ejecutarConsulta(UserQuery query){
		List<GeoReferenced> resultados = new ArrayList<GeoReferenced>();
		XStream xstream = new XStream(new DomDriver());
		
		VisualQuery vsQuery;
		String respuesta = "";
		for(String entidad :  query.getCapas()){
			vsQuery = new VisualQuery(entidad,query.getFiltro());
			try {
				WsTransformadorPortBindingStub cliente = new WsTransformadorPortBindingStub();
				respuesta = cliente.getData(xstream.toXML(vsQuery));
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			List<GeoReferenced> resultado = (List<GeoReferenced>) xstream.fromXML(respuesta);
			Agregar(resultados, resultado);
		}
		return xstream.toXML(resultados);
	}
	
	private List<GeoReferenced> Agregar(List<GeoReferenced> resultados, List<GeoReferenced> resultado){
		for(GeoReferenced<AbstractGeographicElement> ref : resultado)
		{
			resultados.add(ref);
		}
		return resultados;
	}
}
