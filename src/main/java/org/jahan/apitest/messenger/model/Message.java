package org.jahan.apitest.messenger.model;

import java.util.Date;

import jakarta.xml.bind.annotation.XmlRootElement;



@XmlRootElement
public class Message {
	
	private long id;
	private String message;
	private String point;
	private String author;
	
	public Message() {
		
	}
	
	public Message(long id, String message, String point, String author) {
		
		this.id = id;
		this.message = message;
		this.author = author;
		this.point = point;
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getPoint() {
		return point;
	}
	public void setPoint(String point) {
		this.point = point;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	

}
