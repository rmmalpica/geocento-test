
package com.geocento.wsclient;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para intersectionResultBean complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="intersectionResultBean"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="area" type="{http://www.w3.org/2001/XMLSchema}double"/&gt;
 *         &lt;element name="geom" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="geomText" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *         &lt;element name="imageName" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "intersectionResultBean", propOrder = {
    "area",
    "geom",
    "geomText",
    "imageName",
    "imageGeom"
})
public class IntersectionResultBean {

    protected double area;
    protected String geom;
    protected String geomText;
    protected String imageName;
    protected String imageGeom;

    /**
     * Obtiene el valor de la propiedad area.
     * 
     */
    public double getArea() {
        return area;
    }

    /**
     * Define el valor de la propiedad area.
     * 
     */
    public void setArea(double value) {
        this.area = value;
    }

    /**
     * Obtiene el valor de la propiedad geom.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeom() {
        return geom;
    }

    /**
     * Define el valor de la propiedad geom.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeom(String value) {
        this.geom = value;
    }

    /**
     * Obtiene el valor de la propiedad geomText.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getGeomText() {
        return geomText;
    }

    /**
     * Define el valor de la propiedad geomText.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setGeomText(String value) {
        this.geomText = value;
    }

    /**
     * Obtiene el valor de la propiedad imageName.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getImageName() {
        return imageName;
    }

    /**
     * Define el valor de la propiedad imageName.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setImageName(String value) {
        this.imageName = value;
    }

    public String getImageGeom() {
        return imageGeom;
    }

    public void setImageGeom(String imageGeom) {
        this.imageGeom = imageGeom;
    }

    
    
}
