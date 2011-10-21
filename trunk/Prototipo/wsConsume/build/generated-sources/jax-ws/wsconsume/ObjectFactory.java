
package wsconsume;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the wsconsume package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _GetDataFiltro_QNAME = new QName("http://ws.memoria/", "getDataFiltro");
    private final static QName _GetData_QNAME = new QName("http://ws.memoria/", "getData");
    private final static QName _GetDataFiltroResponse_QNAME = new QName("http://ws.memoria/", "getDataFiltroResponse");
    private final static QName _GetDataResponse_QNAME = new QName("http://ws.memoria/", "getDataResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: wsconsume
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link GetData }
     * 
     */
    public GetData createGetData() {
        return new GetData();
    }

    /**
     * Create an instance of {@link GetDataFiltroResponse }
     * 
     */
    public GetDataFiltroResponse createGetDataFiltroResponse() {
        return new GetDataFiltroResponse();
    }

    /**
     * Create an instance of {@link GetDataFiltro }
     * 
     */
    public GetDataFiltro createGetDataFiltro() {
        return new GetDataFiltro();
    }

    /**
     * Create an instance of {@link GetDataResponse }
     * 
     */
    public GetDataResponse createGetDataResponse() {
        return new GetDataResponse();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataFiltro }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.memoria/", name = "getDataFiltro")
    public JAXBElement<GetDataFiltro> createGetDataFiltro(GetDataFiltro value) {
        return new JAXBElement<GetDataFiltro>(_GetDataFiltro_QNAME, GetDataFiltro.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetData }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.memoria/", name = "getData")
    public JAXBElement<GetData> createGetData(GetData value) {
        return new JAXBElement<GetData>(_GetData_QNAME, GetData.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataFiltroResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.memoria/", name = "getDataFiltroResponse")
    public JAXBElement<GetDataFiltroResponse> createGetDataFiltroResponse(GetDataFiltroResponse value) {
        return new JAXBElement<GetDataFiltroResponse>(_GetDataFiltroResponse_QNAME, GetDataFiltroResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link GetDataResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://ws.memoria/", name = "getDataResponse")
    public JAXBElement<GetDataResponse> createGetDataResponse(GetDataResponse value) {
        return new JAXBElement<GetDataResponse>(_GetDataResponse_QNAME, GetDataResponse.class, null, value);
    }

}
