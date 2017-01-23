/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.geocento;

import com.geocento.beans.IntersectionResultBean;
import com.geocento.biz.IntersectionBiz;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author rmg
 */
@WebService(serviceName = "IntersectionWebService")
public class IntersectionWebService {


    /**
     * Web service operation
     */
    @WebMethod(operationName = "intersection")
    public List<IntersectionResultBean> intersection(@WebParam(name = "geom") String geom) 
    {
       IntersectionBiz biz = new IntersectionBiz();
       return biz.intersection(geom);
    }
}
