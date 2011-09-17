
package memoria.ws.jaxws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "getData", namespace = "http://ws.memoria/")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "getData", namespace = "http://ws.memoria/")
public class GetData {

    @XmlElement(name = "params", namespace = "")
    private String params;

    /**
     * 
     * @return
     *     returns String
     */
    public String getParams() {
        return this.params;
    }

    /**
     * 
     * @param params
     *     the value for the params property
     */
    public void setParams(String params) {
        this.params = params;
    }

}
