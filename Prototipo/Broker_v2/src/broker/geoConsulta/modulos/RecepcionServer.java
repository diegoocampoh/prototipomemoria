package broker.geoConsulta.modulos;

import java.io.IOException;
import org.apache.tuscany.sca.host.embedded.SCADomain;

/**
 * Este programa servidor crea un SCA runtime y lo inicializa 
 * lo cual activa el terminal Web service BrokerService.
 */
public class RecepcionServer {

	public static void main(String[] args) {
		SCADomain scaDomain = SCADomain.newInstance("recepcionConsultas_v2.composite");
		try {
            System.out.println("Servidor de recepcion de Consultas inicializado (presione Enter para detenerlo)");
            System.in.read();
			
        } catch (IOException e) {
            e.printStackTrace();
        }

        scaDomain.close();
		
        System.out.println("Recepcion Server finalizado");

	}

}
