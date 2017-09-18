package org.sakila.webservices.dao;

import java.util.List;
import java.util.Optional;

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
	public Optional<Actor> delete(int id){
		Optional<Actor> o;
		try {
			Actor a = em.find(Actor.class, id);
			em.remove(a);
			o = Optional.of(a);
		}catch(Exception e) {
			logger.error(e.getMessage(), e);
			o = Optional.empty();
		}
		return o;
	}
	
	@Transactional
	public Optional<Actor> update(Actor a){
		Optional<Actor> o;
		try {
			Actor a1 = em.find(Actor.class, a.getActorId());
			a1.setFirstName(a.getFirstName());
			a1.setLastName(a.getLastName());
			em.persist(a1);
			o = Optional.of(a1);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			o = Optional.empty();
		}
		return o;
	}

	@Transactional
	public Optional<Actor> save(Actor a) {
		Optional<Actor> o;
		try {
			em.persist(a);
			o = Optional.of(a);
		}catch(Exception e){
			logger.error(e.getMessage(), e);
			o = Optional.empty();
		}
		return o;
	}
	
}
