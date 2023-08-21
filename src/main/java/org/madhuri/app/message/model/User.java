package org.madhuri.app.message.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	
	/*@ManyToMany(mappedBy = "users",fetch = FetchType.EAGER)
	private List<Channel> channels = new ArrayList<>();*/

	public User() {
	}

	public User(Long id, String name, List<Channel> channels) {
		super();
		this.id = id;
		this.name = name;
		//this.channels = channels;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	/*public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public List<Channel> getChannels() {
		return channels;
	}*/

}
