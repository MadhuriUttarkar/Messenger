package org.madhuri.app.message.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "channel")
public class Channel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "channel_name")
	private String channelName;

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
	
	@ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "channel_user",
            joinColumns = @JoinColumn(name = "channel_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
        )
        private List<User> users = new ArrayList<>();

	public Channel() {

	}

	public Channel(Long id, String channelName, Long adminId, String welcomeMessage, Date createdAt, Long createdBy,
			Date updatedAt, Long updatedBy, List<User> users) {
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

	public void addUser(User user) {
        users.add(user);
        user.getChannels().add(this);
    }


}
