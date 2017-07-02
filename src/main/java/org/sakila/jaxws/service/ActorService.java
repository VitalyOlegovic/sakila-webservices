package org.sakila.jaxws.service;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.sakila.jaxws.bean.ActorBean;
import org.sakila.jaxws.dao.ActorDAO;
import org.sakila.jaxws.model.Actor;
import org.sakila.jaxws.toa.ActorTOA;

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
