
package com.geocento.wsclient;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.geocento.wsclient package. 
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

    private final static QName _Intersection_QNAME = new QName("http://geocento.com/", "intersection");
    private final static QName _IntersectionResponse_QNAME = new QName("http://geocento.com/", "intersectionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.geocento.wsclient
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Intersection }
     * 
     */
    public Intersection createIntersection() {
        return new Intersection();
    }

    /**
     * Create an instance of {@link IntersectionResponse }
     * 
     */
    public IntersectionResponse createIntersectionResponse() {
        return new IntersectionResponse();
    }

    /**
     * Create an instance of {@link IntersectionResultBean }
     * 
     */
    public IntersectionResultBean createIntersectionResultBean() {
        return new IntersectionResultBean();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Intersection }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://geocento.com/", name = "intersection")
    public JAXBElement<Intersection> createIntersection(Intersection value) {
        return new JAXBElement<Intersection>(_Intersection_QNAME, Intersection.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link IntersectionResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://geocento.com/", name = "intersectionResponse")
    public JAXBElement<IntersectionResponse> createIntersectionResponse(IntersectionResponse value) {
        return new JAXBElement<IntersectionResponse>(_IntersectionResponse_QNAME, IntersectionResponse.class, null, value);
    }

}
