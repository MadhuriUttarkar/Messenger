package org.madhuri.app.message.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jakarta.xml.bind.annotation.XmlTransient;

@jakarta.xml.bind.annotation.XmlRootElement

public class Msg {
	private long id;
	private String message;
	private Date created;
	private String author;
	private Map<Long, Comment> comments=new HashMap<>();
	private List<Link> links=new ArrayList<>();
	
	public List<Link> getLinks() {
		return links;
	}
	public void setLinks(List<Link> links) {
		this.links = links;
	}
	public Msg()
	{
		
	}
	public Msg(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created=new Date();
	}
	public long getId() {
		return id;
	}
	public String getMessage() {
		return message;
	}
	public Date getCreated() {
		return created;
	}
	public String getAuthor() {
		return author;
	}
	public void setId(long id) {
		this.id = id;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@XmlTransient
	public Map<Long, Comment>getComments()
	{
		return comments;
	}
	public void setComments(Map<Long,Comment>comments)
	{
		this.comments=comments;
	}
	
	public void addLink(String url, String rel)
	{
		Link link=new Link();
		link.setLink(url);
		link.setRel(rel);
		links.add(link);
	}
	public String getContent() {
		// TODO Auto-generated method stub
		return null;
	}

}
