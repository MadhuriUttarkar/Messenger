package org.madhuri.app.message.model;

import java.util.Date;

import jakarta.json.bind.annotation.JsonbProperty;

import jakarta.json.bind.annotation.JsonbDateFormat;


public class Profile {
	
	@JsonbProperty("id")
	private long id;
	
	@JsonbProperty("profileName")
	private String profileName;
	
	@JsonbProperty("firstName")
	private String firstName;
	
	@JsonbProperty("lastName")
	private String lastName;
	
	@JsonbProperty("created")
	@JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private Date created;
	
	@JsonbProperty("username")
    private String username;

    @JsonbProperty("password")
    private String password;
	
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
	public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
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
	public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
