package org.sakila.jaxws.service;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ExampleService {

	@WebMethod
	public String ciao(String nome){
		return "ciao " + nome;
	}
	
}
