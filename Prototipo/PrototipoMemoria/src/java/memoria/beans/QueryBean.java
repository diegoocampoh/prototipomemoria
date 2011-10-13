/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.beans;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author diego
 */
@ManagedBean
@SessionScoped
public class QueryBean {

    private double latcenter;
    private double loncenter;
    private double SWlat;
    private double SWlon;
    private double NElat;
    private double NElon;

    public double getNElat() {
        return NElat;
    }

    public void setNElat(double NElat) {
        this.NElat = NElat;
    }

    public double getNElon() {
        return NElon;
    }

    public void setNElon(double NElon) {
        this.NElon = NElon;
    }

    public double getSWlat() {
        return SWlat;
    }

    public void setSWlat(double SWlat) {
        this.SWlat = SWlat;
    }

    public double getSWlon() {
        return SWlon;
    }

    public void setSWlon(double SWlon) {
        this.SWlon = SWlon;
    }

    public double getLatcenter() {
        return latcenter;
    }

    public void setLatcenter(double latcenter) {
        this.latcenter = latcenter;
    }

    public double getLoncenter() {
        return loncenter;
    }

    public void setLoncenter(double loncenter) {
        this.loncenter = loncenter;
    }



    /** Creates a new instance of QueryBean */
    public QueryBean() {
    }

    public void ejecutarQuery(){

        try {
            String proc = "java -jar D:/facu/Memoria/prototipo-googlecode/Prototipo/wsConsume/dist/wsConsume.jar "+this.SWlat+" "+this.SWlon+" "+this.NElat+" "+this.NElon;
            System.out.println("ejecutando: "+proc);
            Process p = Runtime.getRuntime().exec(proc);
            p.waitFor();
            java.awt.Desktop.getDesktop().browse(new URI("D:/facu/Memoria/prototipo-googlecode/Prototipo/wsConsume/MyFirstMap.html"));
        } catch (InterruptedException ex) {
            Logger.getLogger(QueryBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(QueryBean.class.getName()).log(Level.SEVERE, null, ex);
        } catch (URISyntaxException ex){
            Logger.getLogger(QueryBean.class.getName()).log(Level.SEVERE, null, ex);
        }



    }
}
