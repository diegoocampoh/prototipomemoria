/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 *
 * @author diego
 */
public class XmlSerializable<T> {

    public String toXml(){
        XStream xstream = new XStream(new DomDriver());
        return xstream.toXML(this);
    }

    public T toObject(String xml){
        XStream xstream = new XStream(new DomDriver());
        return ((T)xstream.fromXML(xml));
    }

}
