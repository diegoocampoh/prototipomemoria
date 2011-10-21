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
		System.out.println("Entra a EjecutorConsultaComponentImpl.ejecutarConsulta");
		List<GeoReferenced> resultados = new ArrayList<GeoReferenced>();
		XStream xstream = new XStream(new DomDriver());
		
		VisualQuery vsQuery;
		String respuesta = "";
		for(String entidad :  query.getCapas()){
			
			if (query.getFiltro() == null){
				vsQuery = new VisualQuery(entidad);
			}else{
				vsQuery = new VisualQuery(entidad, query.getFiltro());
			}
			
			try {
				
				WsTransformadorService servicio = new WsTransformadorServiceLocator();
				WsTransformador puerto = servicio.getwsTransformadorPort();
				//String vsQueryStr = xstream.toXML(vsQuery);
				//vsQueryStr = "<memoria.commons.dataAccess.query.VisualQuery><capa>Escuelas</capa></memoria.commons.dataAccess.query.VisualQuery>";
				//System.out.println("EjecutorConsulta realiza consulta a Transformer: " + vsQueryStr);
				//respuesta = puerto.getData(vsQueryStr);
				String capa = "Escuela";
		        
		        double SWlat = -34.91;
		        double SWlon = -56.16;
		        double NElat = -34.89;
		        double NElon = -56.12;
				respuesta = puerto.getDataFiltro(capa,SWlat,SWlon,NElat,NElon);
				//System.out.println("EjecutorConsulta Transformer responde: " + respuesta);
			}catch(Exception e){
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
	
	public static void main(String[] args) {
		/*EjecutorConsultaComponentImpl cons = new EjecutorConsultaComponentImpl();
		UserQuery uq = new UserQuery();
		uq.addCapa("Escuelas");
		cons.ejecutarConsulta(uq);*/
		//System.out.println("Entra a AnalizadorConsultaComponentImp.interpretarConsulta");
				UserQuery us = new UserQuery();
				us.addCapa("Escuela");
				
				XStream xstream = new XStream(new DomDriver());
				String r = xstream.toXML(us);
				System.out.println(r);
	}
}
