/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geocento.beans;

/**
 *
 * @author rmg
 */
public class IntersectionResultBean 
{
    private String geom;
    private String geomText;
    private double area;
    private String imageName;
    private String imageGeom;
    
    public IntersectionResultBean() 
    {
        
    }

    public IntersectionResultBean(String geom, String geomText, double area, 
                                        String imageName, String imageGeom) {
        this.geom = geom;
        this.geomText = geomText;
        this.area = area;
        this.imageName = imageName;
        this.imageGeom = imageGeom;
    }   

    public IntersectionResultBean(String geom, double area) 
    {
        this.geom = geom;
        this.area = area;
    }

    public String getGeom() 
    {
        return geom;
    }

    public void setGeom(String geom) 
    {
        this.geom = geom;
    }

    public double getArea() 
    {
        return area;
    }

    public void setArea(double area) 
    {
        this.area = area;
    }

    public String getGeomText() {
        return geomText;
    }

    public void setGeomText(String geomText) {
        this.geomText = geomText;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }
    
    public String getImageGeom() {
        return imageGeom;
    }

    public void setImageGeom(String imageGeom) {
        this.imageGeom = imageGeom;
    }
        
}
