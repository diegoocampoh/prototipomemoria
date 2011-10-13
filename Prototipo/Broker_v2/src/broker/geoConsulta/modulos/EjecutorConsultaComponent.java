package broker.geoConsulta.modulos;

import org.osoa.sca.annotations.Remotable;
import memoria.commons.dataAccess.query.UserQuery;

@Remotable
public interface EjecutorConsultaComponent {
	String ejecutarConsulta(UserQuery query);
}