package org.sakila.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.sakila.jaxws.bean.ActorBean;

import sakilajpa.dao.ActorDAO;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ActorService {

	@WebMethod
	public void insertActor(@WebParam(name="actor") ActorBean actor){
		// omissis
	}
	
}
