package org.sakila.jaxws.service;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import org.sakila.jaxws.bean.ActorBean;
import org.sakila.jaxws.toa.ActorTOA;

import sakilajpa.dao.ActorDAO;
import sakilajpa.model.Actor;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class ActorService {

	private ActorDAO actorDAO = new ActorDAO();
	
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
	public ArrayList<ActorBean> list(){
		List<Actor> l = actorDAO.list();
		ArrayList<ActorBean> al = ActorTOA.toBean(l);
		return al;
	}
	
}
