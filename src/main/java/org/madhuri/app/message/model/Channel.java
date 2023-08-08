package org.madhuri.app.message.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "channel")
public class Channel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name")
	private String name;

	@Column(name = "admin_id")
	private Long admin_id;

	@Column(name = "welcome_message")
	private String welcome_message;

	@Column(name = "created_at")
	private Date created_at;
	
	@Column(name="created_by")
	private Long created_by;
	
	@Column(name="updated_at")
	private Date updated_at;
	
	@Column(name="updated_by")
	private Long updated_by;

	public Channel() {

	}

	public Channel(Long id, String name, Long admin_id, String welcome_message, Date created_at, Long created_by,
			Date updated_at, Long updated_by) {
		super();
		this.id = id;
		this.name = name;
		this.admin_id = admin_id;
		this.welcome_message = welcome_message;
		this.created_at = created_at;
		this.created_by = created_by;
		this.updated_at = updated_at;
		this.updated_by = updated_by;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getAdmin_id() {
		return admin_id;
	}

	public String getWelcome_message() {
		return welcome_message;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public Long getCreated_by() {
		return created_by;
	}

	public Date getUpdated_at() {
		return updated_at;
	}

	public Long getUpdated_by() {
		return updated_by;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdmin_id(Long admin_id) {
		this.admin_id = admin_id;
	}

	public void setWelcome_message(String welcome_message) {
		this.welcome_message = welcome_message;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public void setCreated_by(Long created_by) {
		this.created_by = created_by;
	}

	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}

	public void setUpdated_by(Long updated_by) {
		this.updated_by = updated_by;
	}

	
}
