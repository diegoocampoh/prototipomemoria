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
public abstract class GisFilter {

    public abstract List<GeoReferenced> filter(List<GeoReferenced> data);

}
