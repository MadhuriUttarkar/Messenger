package org.madhuri.app.message.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "channel_user")
public class ChannelUser {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "user_id")
	private Long userId;
	
	@Column(name = "channel_id")
	private Long channelId;

	public ChannelUser() {

	}

	public ChannelUser(Long id, Long userId, Long channelId) {
		this.id = id;
		this.userId = userId;
		this.channelId = channelId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getChannelId() {
		return channelId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}

}

