package broker.geoConsulta.modulos;

import org.osoa.sca.annotations.Remotable;

@Remotable
public interface ReceptorConsultaComponent {
	public String obtenerGeoInfo(String xml);
}
