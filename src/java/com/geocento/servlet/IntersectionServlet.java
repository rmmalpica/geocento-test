/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geocento.servlet;

import com.geocento.wsclient.IntersectionWebService_Service;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.WebServiceRef;

/**
 *
 * @author rmg
 */
@WebServlet(name = "IntersectionServlet", urlPatterns = {"/IntersectionServlet"})
public class IntersectionServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/IntersectionWebService.wsdl")
    private IntersectionWebService_Service service;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         
            PrintWriter out = response.getWriter();
            String geom;
            geom = request.getParameter("geometry");
            
            List<com.geocento.wsclient.IntersectionResultBean> list = this.intersection(geom);
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>IntersectionServlet result</title>"); 
       //     out.println("<script src=\"http://openlayers.org/api/OpenLayers.js\"></script>");
            out.println("<style>");
            out.println("table {");
            out.println("border-collapse: collapse;");
            out.println("width: 100%;");             
            out.println("}");
            out.println("table, td, th {");
            out.println("border: 1px solid black;");
            out.println("height: 50px;");
            out.println("}");
            out.println("td {");
            out.println("border: 1px solid black;");
           // out.println("height: 25px;");
            out.println("max-width: 250px;");       
            out.println("text-align: center");
            out.println("}");
            out.println("</style>");
            out.println("</head>");
            out.println("<body>");            
            out.println("<h3>Intersection result</h3>");            
            out.println("<br>");
            out.println("<p>Number of images: "+list.size()+" </p>");
            out.println("<br>");
            
            String json = "[";
            for (int i=0; i < list.size(); i++)
            {
                com.geocento.wsclient.IntersectionResultBean bean = 
                        new com.geocento.wsclient.IntersectionResultBean();
                bean = list.get(i);
                
                json += "{"; 
            //    json += "geom:" + bean.getGeom()+",";
                json += "\"geomText\":\"" + bean.getGeomText()+"\",";
                json += "\"area\":\"" + bean.getArea()+"\",";  
                json += "\"imageName\":\"" + bean.getImageName() + "\",";      
                json += "\"imageGeom\":\"" + bean.getImageGeom() + "\""; 
                json += "},";
            }
            json = json.substring(0, json.length() - 1);
            json += "]";
            
            out.println("<a href=\"map.jsp?intersection="+URLEncoder.encode(json, "UTF-8")+"\">View in map</a>"); 
            out.println("<br>");
            out.println("<table>");            
            out.println("<tr>");
       //     out.println("<th>Geom</th>");
            out.println("<th>IntersectionGeom</th>");
            out.println("<th>Area</th>");
            out.println("<th>ImageName</th>");
            out.println("<th>ImageGeom</th>");
            out.println("</tr>");
                    
            for (int i=0; i < list.size(); i++)
            {
                com.geocento.wsclient.IntersectionResultBean bean = 
                        new com.geocento.wsclient.IntersectionResultBean();
                bean = list.get(i);
                
                out.println("<tr>");
            //    out.println("<td>"+bean.getGeom()+"</td>");
                out.println("<td>"+bean.getGeomText()+"</td>");
                out.println("<td>"+bean.getArea()+"</td>");
                out.println("<td>"+bean.getImageName()+"</td>");
                  out.println("<td>"+bean.getImageGeom()+"</td>");
                out.println("</tr>");
                 
            }
            
            out.println("</table>");            
            out.println("<br>");            
       /*     out.println("<div style=\"width:1200px; height:1000px;\" id=\"map\"></div>");            
            out.println("<script defer=\"defer\" type=\"text/javascript\">");            
            out.println("var map = new OpenLayers.Map('map');");            
            out.println("var wms = new OpenLayers.Layer.WMS( \"OpenLayers WMS\",");            
            out.println("\"http://vmap0.tiles.osgeo.org/wms/vmap0\", {layers: 'basic'} );");            
            out.println("map.addLayer(wms);"); 
            out.println("map.setCenter([-3.6827461557, 40.4893538421231],6);"); 
            out.println("</script>"); */
                               
     
            out.println("</body>");
            out.println("</html>");
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Servlet for calling to WSClient Intersection";
    }// </editor-fold>

    private java.util.List<com.geocento.wsclient.IntersectionResultBean> intersection(java.lang.String geom) {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.geocento.wsclient.IntersectionWebService port = service.getIntersectionWebServicePort();
        return port.intersection(geom);
    }

}
