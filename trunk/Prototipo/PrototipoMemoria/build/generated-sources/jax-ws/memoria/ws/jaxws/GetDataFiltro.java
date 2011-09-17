
package memoria.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getDataFiltro", namespace = "http://ws.memoria/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDataFiltro", namespace = "http://ws.memoria/", propOrder = {
    "capa",
    "latSurOesteVisor",
    "lonSurOesteVisor",
    "latNorEsteVisor",
    "lonNorEsteVisor"
})
public class GetDataFiltro {

    @XmlElement(name = "capa", namespace = "")
    private String capa;
    @XmlElement(name = "latSurOesteVisor", namespace = "")
    private Double latSurOesteVisor;
    @XmlElement(name = "lonSurOesteVisor", namespace = "")
    private Double lonSurOesteVisor;
    @XmlElement(name = "latNorEsteVisor", namespace = "")
    private Double latNorEsteVisor;
    @XmlElement(name = "lonNorEsteVisor", namespace = "")
    private Double lonNorEsteVisor;

    /**
     * 
     * @return
     *     returns String
     */
    public String getCapa() {
        return this.capa;
    }

    /**
     * 
     * @param capa
     *     the value for the capa property
     */
    public void setCapa(String capa) {
        this.capa = capa;
    }

    /**
     * 
     * @return
     *     returns Double
     */
    public Double getLatSurOesteVisor() {
        return this.latSurOesteVisor;
    }

    /**
     * 
     * @param latSurOesteVisor
     *     the value for the latSurOesteVisor property
     */
    public void setLatSurOesteVisor(Double latSurOesteVisor) {
        this.latSurOesteVisor = latSurOesteVisor;
    }

    /**
     * 
     * @return
     *     returns Double
     */
    public Double getLonSurOesteVisor() {
        return this.lonSurOesteVisor;
    }

    /**
     * 
     * @param lonSurOesteVisor
     *     the value for the lonSurOesteVisor property
     */
    public void setLonSurOesteVisor(Double lonSurOesteVisor) {
        this.lonSurOesteVisor = lonSurOesteVisor;
    }

    /**
     * 
     * @return
     *     returns Double
     */
    public Double getLatNorEsteVisor() {
        return this.latNorEsteVisor;
    }

    /**
     * 
     * @param latNorEsteVisor
     *     the value for the latNorEsteVisor property
     */
    public void setLatNorEsteVisor(Double latNorEsteVisor) {
        this.latNorEsteVisor = latNorEsteVisor;
    }

    /**
     * 
     * @return
     *     returns Double
     */
    public Double getLonNorEsteVisor() {
        return this.lonNorEsteVisor;
    }

    /**
     * 
     * @param lonNorEsteVisor
     *     the value for the lonNorEsteVisor property
     */
    public void setLonNorEsteVisor(Double lonNorEsteVisor) {
        this.lonNorEsteVisor = lonNorEsteVisor;
    }

}
