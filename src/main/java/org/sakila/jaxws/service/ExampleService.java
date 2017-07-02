package org.sakila.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ExampleService {

	@WebMethod
	@WebResult(name="saluto")
	public String ciao(@WebParam(name="nome") String nome){
		return "ciao " + nome;
	}
	
}
