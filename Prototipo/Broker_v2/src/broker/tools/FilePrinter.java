package broker.tools;

import java.io.BufferedWriter;
import java.io.IOException;

import de.schlichtherle.io.FileWriter;

public class FilePrinter {

	public static void imprimirSalida(String resultado, String fileName){
		BufferedWriter writer = null;
        try
        {
                writer = new BufferedWriter(new FileWriter(fileName));
                writer.write(resultado);

        }
        catch ( IOException e)
        {
        }
        finally
        {
                try
                {
                        if ( writer != null)
                                writer.close( );
                }
                catch ( IOException e)
                {
                }
     }
	}
}
