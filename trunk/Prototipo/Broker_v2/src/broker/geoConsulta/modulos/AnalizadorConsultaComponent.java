package broker.geoConsulta.modulos;

import org.osoa.sca.annotations.Remotable;

@Remotable
public interface AnalizadorConsultaComponent {
	public String interpretarConsulta(String xml);
}
