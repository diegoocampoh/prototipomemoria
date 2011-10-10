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
        return XStreamInstance.toXml(this);
    }

    public T toObject(String xml){
        return ((T)XStreamInstance.toObject(xml));
    }

}
