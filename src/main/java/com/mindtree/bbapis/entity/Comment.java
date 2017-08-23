package com.mindtree.bbapis.entity;

import java.util.UUID;

public class Comment {
	private String id;
	private String value;
	private String date;
	private Owners user;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Owners getUser() {
		return user;
	}

	public void setUser(Owners user) {
		this.user = user;
	}

	public Comment(String type) {
		this.id = String.valueOf(UUID.randomUUID());
		this.value = type;
		this.date = "2017-01-22T00:08:00Z";
		this.user = new Owners();
	}

	public Comment() {
	}
}
