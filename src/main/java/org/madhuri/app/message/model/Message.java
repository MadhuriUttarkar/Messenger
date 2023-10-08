package org.madhuri.app.message.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.json.bind.annotation.JsonbDateFormat;

@Entity
@Table(name = "message")
public class Message {

	@JsonbProperty("id")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@JsonbProperty("messageContent")
	@Column(name = "message_content")
	private String messageContent;

	@JsonbProperty("created")
	@Column(name = "created")
	@JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
	private Date created;

	@JsonbProperty("userId")
	@Column(name = "user_id")
	private Long userId;

	@JsonbProperty("recipientId")
	@Column(name = "recipient_id")
	private Long recipientId;

	@JsonbTransient
	@Transient
	private Channel channel;
	
	@JsonbProperty("channelId")
	@Column(name = "channel_id")
	private Long channelId;

	public Message() {
	}

	public Message(long id, String messageContent, Date created, Long userId, Long recipientId, Channel channel,Long channelId) {
		super();
		this.id = id;
		this.messageContent = messageContent;
		this.created = created;
		this.userId = userId;
		this.recipientId = recipientId;
		this.channel = channel;
		this.channelId= channelId;
	}

	public long getId() {
		return id;
	}

	public String getMessageContent() {
		return messageContent;
	}

	public Date getCreated() {
		return created;
	}

	public Long getUserId() {
		return userId;
	}

	public Long getRecipientId() {
		return recipientId;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public void setRecipientId(Long recipientId) {
		this.recipientId = recipientId;
	}

	public Channel getChannel() {
		return channel;
	}

	public void setChannel(Channel channel) {
		this.channel = channel;
	}
	
	public Long getChannelId() {
		return channelId;
	}
	
	public void setChannelId(long channelId) {
		
		this.channelId = channelId;

	}

}
