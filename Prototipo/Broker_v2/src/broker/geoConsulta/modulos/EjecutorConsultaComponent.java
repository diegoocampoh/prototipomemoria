package broker.geoConsulta.modulos;

import org.osoa.sca.annotations.Remotable;

@Remotable
public interface EjecutorConsultaComponent {
	String ejecutarConsulta(String xml);
}