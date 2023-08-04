package org.madhuri.app.message.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="MessageGroup")
public class MessageGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="groupName")
    private String groupName;

    @Column(name="groupAdmin")
    private String groupAdmin;

    @Column(name="groupMessages")
    private String groupMessages;

    @Column(name = "created")
    private Date created;

    
    public MessageGroup() {
    	
    }

    public MessageGroup(String groupName, String groupAdmin, String groupMessages, Date created) {
        this.groupName = groupName;
        this.groupAdmin = groupAdmin;
        this.groupMessages = groupMessages;
        this.created = created;
    }
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupAdmin() {
        return groupAdmin;
    }

    public void setGroupAdmin(String groupAdmin) {
        this.groupAdmin = groupAdmin;
    }

    public String getGroupMessages() {
        return groupMessages;
    }

    public void setGroupMessages(String groupMessages) {
        this.groupMessages = groupMessages;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
