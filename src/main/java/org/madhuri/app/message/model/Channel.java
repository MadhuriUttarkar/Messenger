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
@Table(name = "channel")
public class Channel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonbProperty("id")
	@Column(name = "id")
	private Long id;

	@Column(name = "channel_name")
	@JsonbProperty("channelName")
	private String channelName;

	@Column(name = "admin_id")
	@JsonbProperty("adminId")
	private Long adminId;

	@Column(name = "welcome_message")
	@JsonbProperty("welcomeMessage")
	private String welcomeMessage;

	@Column(name = "created_at")
	@JsonbProperty("createdAt")
	@JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private Date createdAt;

	@Column(name = "created_by")
	@JsonbProperty("createdBy")
	private Long createdBy;

	@Column(name = "updated_at")
	@JsonbProperty("updatedAt")
	@JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private Date updatedAt;

	@Column(name = "updated_by")
	@JsonbProperty("updatedBy")
	private Long updatedBy;

	@JsonbTransient
	@Transient
	private List<User> users = new ArrayList<>();
	
	@JsonbTransient
	@Transient
	private List<Message> messages = new ArrayList<>();
	

	public Channel() {

	}

	public Channel(Long id, String channelName, Long adminId, String welcomeMessage, Date createdAt, Long createdBy,
			Date updatedAt, Long updatedBy, List<User> users,List<Message>messages) {
		super();
		this.id = id;
		this.channelName = channelName;
		this.adminId = adminId;
		this.welcomeMessage = welcomeMessage;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.updatedAt = updatedAt;
		this.updatedBy = updatedBy;
		this.users = users;
		this.messages = messages;
	}

	public Long getId() {
		return id;
	}

	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
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

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public void setMessages(List<Message> messages) {
		this.messages = messages;
	}	
}
