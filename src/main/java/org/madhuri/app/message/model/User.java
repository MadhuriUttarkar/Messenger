package org.madhuri.app.message.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import jakarta.json.bind.annotation.JsonbDateFormat;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;

@Entity
@Table(name = "users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonbProperty("id")
	private Long id;

	@Column(name = "name")
	@JsonbProperty("name")
	private String name;

	@JsonbTransient
	@Transient
	private List<Channel> channels = new ArrayList<>();

	@Column(name = "updated_at")
	@JsonbProperty("updatedAt")
	@JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private Date updatedAt;

	public User() {
	}

	public User(Long id, String name, List<Channel> channels, Date updatedAt) {
		super();
		this.id = id;
		this.name = name;
		this.channels = channels;
		this.updatedAt = updatedAt;
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

	public void setChannels(List<Channel> channels) {
		this.channels = channels;
	}

	public List<Channel> getChannels() {
		return channels;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

}
