package org.sakila.rest.service;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.sakila.rest.bean.ActorBean;
import org.sakila.rest.toa.ActorTOA;
import org.sakila.webservices.dao.ActorDAO;
import org.sakila.webservices.model.Actor;

@Path("/actor")
@Produces(MediaType.APPLICATION_JSON)
public class ActorRESTService {

	@Inject
	private ActorDAO actorDAO;
	
	@GET
	public Response list(){
		List<Actor> l = actorDAO.list();
		ArrayList<ActorBean> al = ActorTOA.toBean(l);
		return Response.ok(al, MediaType.APPLICATION_JSON).build();
	}
	
}
