package org.sakila.soap.bean;

import java.util.Date;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="actor")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActorBean {
	@XmlElement
	private int id;
	@XmlElement( required=true, nillable=false )
	private String firstName;
	@XmlElement( required=true, nillable=false )
	private String lastName;
	
	private Date lastUpdate;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getLastUpdate() {
		return lastUpdate;
	}
	public void setLastUpdate(Date lastUpdate) {
		this.lastUpdate = lastUpdate;
	}
	
	
}
