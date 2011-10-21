
package wsconsume;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for getDataFiltro complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="getDataFiltro">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="capa" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="latSurOesteVisor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="lonSurOesteVisor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="latNorEsteVisor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="lonNorEsteVisor" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getDataFiltro", propOrder = {
    "capa",
    "latSurOesteVisor",
    "lonSurOesteVisor",
    "latNorEsteVisor",
    "lonNorEsteVisor"
})
public class GetDataFiltro {

    protected String capa;
    protected Double latSurOesteVisor;
    protected Double lonSurOesteVisor;
    protected Double latNorEsteVisor;
    protected Double lonNorEsteVisor;

    /**
     * Gets the value of the capa property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCapa() {
        return capa;
    }

    /**
     * Sets the value of the capa property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCapa(String value) {
        this.capa = value;
    }

    /**
     * Gets the value of the latSurOesteVisor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLatSurOesteVisor() {
        return latSurOesteVisor;
    }

    /**
     * Sets the value of the latSurOesteVisor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLatSurOesteVisor(Double value) {
        this.latSurOesteVisor = value;
    }

    /**
     * Gets the value of the lonSurOesteVisor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLonSurOesteVisor() {
        return lonSurOesteVisor;
    }

    /**
     * Sets the value of the lonSurOesteVisor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLonSurOesteVisor(Double value) {
        this.lonSurOesteVisor = value;
    }

    /**
     * Gets the value of the latNorEsteVisor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLatNorEsteVisor() {
        return latNorEsteVisor;
    }

    /**
     * Sets the value of the latNorEsteVisor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLatNorEsteVisor(Double value) {
        this.latNorEsteVisor = value;
    }

    /**
     * Gets the value of the lonNorEsteVisor property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getLonNorEsteVisor() {
        return lonNorEsteVisor;
    }

    /**
     * Sets the value of the lonNorEsteVisor property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setLonNorEsteVisor(Double value) {
        this.lonNorEsteVisor = value;
    }

}
