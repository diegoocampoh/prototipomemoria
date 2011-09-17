/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.dataAccess.query.filtro;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import memoria.commons.structures.GeoReferenced;

/**
 *
 * @author diego
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace="http://GisFilter")
public abstract class GisFilter {

    @XmlElement(name="test", type=String.class)
    public String test;
    
    public abstract List<GeoReferenced> filter(List<GeoReferenced> data);

}
