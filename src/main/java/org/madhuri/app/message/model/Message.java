package org.madhuri.app.message.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbDateFormat; 

@Entity
@Table(name = "Message")
public class Message{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	@JsonbProperty("id")
    private long id;

    @Column(name="messageContent")
    @JsonbProperty("messageContent")
    private String messageContent;

    @Column(name="created")
    @JsonbProperty("created")
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private Date created;

    @Column(name="username")
    @JsonbProperty("username")
    private String username;
    

    @Column(name = "recipient")
    @JsonbProperty("recipient")
    private String recipient;


    public Message() {
    }
    
    public Message(long id, String messageContent, Date created, String username, String recipient) {
        super();
        this.id = id;
        this.messageContent = messageContent;
        this.created = created;
        this.username = username;
        this.recipient = recipient;
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


	public String getUsername() {
		return username;
	}


	public String getRecipient() {
		return recipient;
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


	public void setUsername(String username) {
		this.username = username;
	}


	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}
}
