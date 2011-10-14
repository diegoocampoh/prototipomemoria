package starter;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

import memoria.commons.dataAccess.query.UserQuery;
import memoria.commons.dataAccess.query.VisualQuery;
import memoria.commons.structures.GeoReferenced;
import memoria.ws.WsTransformadorPortBindingStub;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

import consulta.ReceptorConsultaComponent;
import consulta.ReceptorConsultaComponentBindingStub;


public class StartUp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Iniciando cliente");
		XStream xstream = new XStream(new DomDriver());
		String respuesta = "";
		List<String> entidades = new ArrayList<String>();
		entidades.add("Escuela");
		UserQuery query = new UserQuery(entidades);
		
			
			try {
				String consStr = xstream.toXML(query);
				System.out.println("Consulta enviada desde cliente: \n" + consStr);
				ReceptorConsultaComponent stub = new ReceptorConsultaComponentBindingStub();
				
				respuesta = stub.obtenerGeoInfo(consStr);
				System.out.println("Respuesta Broker: " + respuesta);
			} catch (RemoteException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		
			
			List<GeoReferenced> resultado = (List<GeoReferenced>) xstream.fromXML(respuesta);
			for(GeoReferenced data: resultado){
				System.out.println(data.getNombre() + " Desc: " + data.getDescripcion());
			}
		}
		

	}

}
