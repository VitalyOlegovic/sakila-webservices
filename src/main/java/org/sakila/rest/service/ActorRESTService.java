package org.sakila.rest.service;

import java.util.ArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.sakila.rest.bean.ActorBean;

@Path("/actor")
@Produces(MediaType.APPLICATION_JSON)
public class ActorRESTService {

	@GET
	public Response list(){
		return Response.ok(new ActorBean(), MediaType.APPLICATION_JSON).build();
	}
	
}
