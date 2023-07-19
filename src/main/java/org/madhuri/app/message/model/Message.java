package org.madhuri.app.message.model;

import java.util.Date;
import jakarta.json.bind.annotation.JsonbProperty;
import jakarta.json.bind.annotation.JsonbDateFormat;


public class Message {

    @JsonbProperty("id")
    private long id;

    @JsonbProperty("messageContent")
    private String messageContent;

    @JsonbProperty("created")
    @JsonbDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ")
    private Date created;

    @JsonbProperty("username")
    private String username;


    public Message(long id, String messageContent, Date created, String username) {
        super();
        this.id = id;
        this.messageContent = messageContent;
        this.created = created;
        this.username = username;
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
}
