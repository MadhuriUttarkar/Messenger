package org.madhuri.app.message.model;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;
@XmlRootElement
public class Profile {
	private long id;
	private String profileName;
	private String firstName;
	private String lastName;
	private Date created;
	
	public Profile()
	{
		
	}
	public Profile(long id, String profileName, String firstName, String lastName, Date created) {
		this.id = id;
		this.profileName = profileName;
		this.firstName = firstName;
		this.lastName = lastName;
		this.created = created;
	}
	public long getId() {
		return id;
	}
	public String getProfileName() {
		return profileName;
	}
	public String getFirstName() {
		return firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public Date getCreated() {
		return created;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setProfileName(String profileName) {
		this.profileName = profileName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	
}
