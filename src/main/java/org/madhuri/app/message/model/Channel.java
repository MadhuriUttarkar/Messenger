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
	private Long adminId;

	@Column(name = "welcome_message")
	private String welcomeMessage;

	@Column(name = "created_at")
	private Date createdAt;

	@Column(name = "created_by")
	private Long createdBy;

	@Column(name = "updated_at")
	private Date updatedAt;

	@Column(name = "updated_by")
	private Long updatedBy;

	public Channel() {

	}

	public Channel(Long id, String name, Long adminId, String welcomeMessage, Date createdAt, Long createdBy,
			Date updatedAt, Long updatedBy) {
		super();
		this.id = id;
		this.name = name;
		this.adminId = adminId;
		this.welcomeMessage = welcomeMessage;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Long getAdminId() {
		return adminId;
	}

	public String getWelcomeMessage() {
		return welcomeMessage;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public Long getCreatedBy() {
		return createdBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public Long getUpdatedBy() {
		return updatedBy;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public void setWelcomeMessage(String welcomeMessage) {
		this.welcomeMessage = welcomeMessage;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public void setCreatedBy(Long createdBy) {
		this.createdBy = createdBy;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setUpdatedBy(Long updatedBy) {
		this.updatedBy = updatedBy;
	}

}
