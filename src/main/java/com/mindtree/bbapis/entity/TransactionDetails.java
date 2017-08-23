package com.mindtree.bbapis.entity;

public class TransactionDetails {
	private String type;
	private String description;
	private String postedDate;
	private String completedDate;
	private Balance new_balance;
	private Balance value;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}

	public String getCompletedDate() {
		return completedDate;
	}

	public void setCompletedDate(String completedDate) {
		this.completedDate = completedDate;
	}

	public Balance getNew_balance() {
		return new_balance;
	}

	public void setNew_balance(Balance new_balance) {
		this.new_balance = new_balance;
	}

	public Balance getValue() {
		return value;
	}

	public void setValue(Balance value) {
		this.value = value;
	}

}
