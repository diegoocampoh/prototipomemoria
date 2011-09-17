/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.structures;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author diego
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(namespace="http://georeferenced")
public abstract class GeoReferenced<T extends AbstractGeographicElement> {

    @XmlElement(name = "representation")
    public abstract T getSpatialRepresentation();

}
