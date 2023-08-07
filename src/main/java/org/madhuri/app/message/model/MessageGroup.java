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
    @Column(name="groupid")
    private Long groupid;

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


	public MessageGroup(Long groupid, String groupName, String groupAdmin, String groupMessages, Date created) {
		this.groupid = groupid;
		this.groupName = groupName;
		this.groupAdmin = groupAdmin;
		this.groupMessages = groupMessages;
		this.created = created;
	}


	public Long getGroupid() {
		return groupid;
	}


	public String getGroupName() {
		return groupName;
	}


	public String getGroupAdmin() {
		return groupAdmin;
	}


	public String getGroupMessages() {
		return groupMessages;
	}


	public Date getCreated() {
		return created;
	}
	
	
	
	public void setGroupid(Long groupid) {
		this.groupid = groupid;
	}


	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}


	public void setGroupAdmin(String groupAdmin) {
		this.groupAdmin = groupAdmin;
	}


	public void setGroupMessages(String groupMessages) {
		this.groupMessages = groupMessages;
	}


	public void setCreated(Date created) {
		this.created = created;
	}
	
    }
