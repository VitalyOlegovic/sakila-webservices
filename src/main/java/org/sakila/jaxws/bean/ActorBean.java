package org.sakila.jaxws.bean;

import javax.xml.bind.annotation.*;

@XmlRootElement(name="actor")
@XmlAccessorType(XmlAccessType.FIELD)
public class ActorBean {
	@XmlElement(required=true,nillable=false)
	private String firstName;
	@XmlElement(required=true,nillable=false)
	private String lastName;
	
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
	
	
}
