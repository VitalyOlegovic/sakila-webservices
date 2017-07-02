package org.sakila.soap.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.sakila.soap.bean.ActorBean;
import org.sakila.soap.toa.ActorTOA;
import org.sakila.webservices.dao.ActorDAO;
import org.sakila.webservices.model.Actor;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ActorService {

	@Inject
	private ActorDAO actorDAO;
	
	@WebMethod
	public void insertActor(@WebParam(name="actor") ActorBean actor){
		Actor a = ActorTOA.toModel(actor);
		actorDAO.save(a);
	}

	@WebMethod
    public void deleteActor(@WebParam(name="id") int id){
	    actorDAO.delete(id);
    }

	@WebMethod
	@WebResult(name="actors")
	public ArrayList<ActorBean> list(){
		List<Actor> l = actorDAO.list();
		ArrayList<ActorBean> al = ActorTOA.toBean(l);
		return al;
	}
	
	@WebMethod
	public void updateActor(@WebParam(name="actor") ActorBean actor){
		Actor a = ActorTOA.toModel(actor);
		actorDAO.update(a);
	}
}
