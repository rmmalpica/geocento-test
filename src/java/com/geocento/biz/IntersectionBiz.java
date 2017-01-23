/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geocento.biz;

import com.geocento.beans.IntersectionResultBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rmg
 */
public class IntersectionBiz 
{    
    Connection con = null;
    
    private void connect() 
    {        
        try 
        {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/intersect-db",
            "intersect-user", "intersect-user");
        } 
        catch (ClassNotFoundException | SQLException e) 
        {                      
            Logger.getLogger(IntersectionBiz.class.getName()).log(Level.SEVERE, null, e);
        }
             
    }
    
    private void disconnect()
    {
        try 
        {
            if(con != null)
                con.close();
            
        } catch (SQLException ex) 
        {
            Logger.getLogger(IntersectionBiz.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 
    public List<IntersectionResultBean> intersection(String geom)
    {        
        ArrayList list = new ArrayList();
        this.connect();
        
        //POLYGON((-12.0000 36.0000, -6.0000 36.0000, -6.0000 62.3300,-12.0000  62.3300, -12.0000 36.0000))
        String query = "select a.intersection_geom as intersectionGeom, "
                + " ST_AsText(a.intersection_geom) as intersectionGeomText, "
                + " ST_Area(a.intersection_geom, true) / 1000000 as area, "
                + " a.location, "
                + " a.imageGeom "
                + " from "
                + " (select ST_intersection(ST_GeogFromText('SRID=4326;" + geom + "'), geom) "
                + " as intersection_geom, location,  ST_AsText(geom) as imageGeom from pnoa_images) a";
        
        try 
        {
            Statement st = con.createStatement();            
            ResultSet rs = st.executeQuery(query);
            
            while(rs.next())
            {
                double area = rs.getDouble("area");
                String intersectionGeomText = rs.getString("intersectionGeomText");
                String intersectionGeom = rs.getString("intersectionGeom");
                String imageName = rs.getString("location");
                String imageGeom = rs.getString("imageGeom");
                
                if(area > 0)
                {
                    IntersectionResultBean bean = new IntersectionResultBean();
                
                    bean.setArea(area);
                    bean.setGeom(intersectionGeom);
                    bean.setGeomText(intersectionGeomText);
                    bean.setImageName(imageName);
                    bean.setImageGeom(imageGeom);
                
                    list.add(bean);
                }
            }
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(IntersectionBiz.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        this.disconnect();
        return list;
    }
}
