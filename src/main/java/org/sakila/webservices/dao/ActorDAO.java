package org.sakila.webservices.dao;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.sakila.webservices.model.Actor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ActorDAO {

	private final static Logger logger = LoggerFactory.getLogger(ActorDAO.class);
	
	@PersistenceContext(unitName="sakila")
	private EntityManager em;
	
	public List<Actor> list(){
		TypedQuery<Actor> q = em.createNamedQuery("Actor.findAll", Actor.class);
		List<Actor> l = q.getResultList();
		return l;
	}
	
	public Actor find(int id){
		Actor a = em.find(Actor.class, id);
		return a;
	}
	
	@Transactional
	public void delete(int id){
		Actor a = em.find(Actor.class, id);
		em.remove(a);
	}
	
	@Transactional
	public void update(Actor a){
		Actor a1 = em.find(Actor.class, a.getActorId());
		a1.setFirstName(a.getFirstName());
		a1.setLastName(a.getLastName());
		em.persist(a1);
	}

	@Transactional
	public void save(Actor a) {
		em.persist(a);
	}
	
}
