/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package memoria.commons.xml;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.xml.DomDriver;

/**
 * Pretende ser un singleton del xstream
 * @author diego
 */
public class XStreamInstance {

    static XStream xstream =  new XStream(new DomDriver());

    public static String toXml(Object o){
        return xstream.toXML(o);
    }

    public static Object toObject(String xml){
        return xstream.fromXML(xml);
    }


}
