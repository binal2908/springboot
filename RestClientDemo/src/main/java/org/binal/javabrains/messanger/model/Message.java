package org.binal.javabrains.messanger.model;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Message {
	@Override
	public String toString() {
		return "Message [id=" + id + ", message=" + message + ", author="
				+ author + ", created=" + created + "]";
	}

	private long id;
	private String message;
	private String author;
	private Date created;

	// when playing with xml and json we DO need default constructor for
	// conversion of our message to json and xml
	public Message() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Message(long id, String message, String author) {
		this.id = id;
		this.message = message;
		this.author = author;
		this.created = new Date();
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

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

}
