package com.mindtree.bbapis.entity;

import java.util.ArrayList;
import java.util.List;

public class TransactionMetadata {
	private String narrative;
	private List<Comment> comments = new ArrayList<Comment>();
	private List<Comment> tags = new ArrayList<Comment>();

	public String getNarrative() {
		return narrative;
	}

	public void setNarrative(String narrative) {
		this.narrative = narrative;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

	public List<Comment> getTags() {
		return tags;
	}

	public void setTags(List<Comment> tags) {
		this.tags = tags;
	}

	public TransactionMetadata() {
		this.narrative = "NONE";
		this.comments.add(new Comment("comment"));
		this.tags.add(new Comment("tag"));
	}
}
