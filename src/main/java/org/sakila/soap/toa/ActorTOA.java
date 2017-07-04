package org.sakila.soap.toa;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.sakila.soap.bean.ActorBean;
import org.sakila.webservices.model.Actor;

public class ActorTOA {

	public static Actor toModel(ActorBean ab){
		Actor a = new Actor();
		a.setActorId(ab.getId());
		a.setFirstName(ab.getFirstName());
		a.setLastName(ab.getLastName());
		
		if(ab.getLastUpdate() != null){
			long time = ab.getLastUpdate().getTime();
			Timestamp t = new Timestamp(time);
			a.setLastUpdate(t);
		}else{
			a.setLastUpdate(new Timestamp(System.currentTimeMillis()));
		}
		
		return a;
	}
	
	public static ActorBean toBean(Actor a){
		ActorBean ab = new ActorBean();
		ab.setId(a.getActorId());
		ab.setFirstName(a.getFirstName());
		ab.setLastName(a.getLastName());
		
		if(a.getLastUpdate() != null){
			long time = a.getLastUpdate().getTime();
			Date d = new Date(time);
			ab.setLastUpdate(d);
		}else{
			ab.setLastUpdate(new Date());
		}
		
		return ab;
	}
	
	public static ArrayList<ActorBean> toBean(List<Actor> l){
		ArrayList<ActorBean> al = new ArrayList<>();
		
		for(Actor a : l){
			ActorBean ab = toBean(a);
			al.add(ab);
		}
		
		return al;
	}
	
}
