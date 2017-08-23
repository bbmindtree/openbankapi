package com.mindtree.bbapis.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "TRANSACTIONS")
public class TransactionDAO {

	@Id
	@Column(name = "ID", unique = true)
	@NotNull
	private String id;

	@Column(name = "THIS_ACCOUNT", length = 12)
	@NotNull
	private String thisAccount;

	@Column(name = "OTHER_ACCOUNT", length = 12)
	@NotNull
	private String otherAccount;

	@Column(name = "POSTED_DATE")
	@NotNull
	private String postedDate;

	@Column(name = "COMPLETE_DATE")
	@NotNull
	private String completeDate;

	@Column(name = "AMOUNT")
	@NotNull
	private Double amount;

	@Column(name = "TYPE")
	@NotNull
	private String type;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getThisAccount() {
		return thisAccount;
	}

	public void setThisAccount(String thisAccount) {
		this.thisAccount = thisAccount;
	}

	public String getOtherAccount() {
		return otherAccount;
	}

	public void setOtherAccount(String otherAccount) {
		this.otherAccount = otherAccount;
	}

	public Double getAmount() {
		return amount;
	}

	public String getPostedDate() {
		return postedDate;
	}

	public void setPostedDate(String postedDate) {
		this.postedDate = postedDate;
	}

	public String getCompleteDate() {
		return completeDate;
	}

	public void setCompleteDate(String completeDate) {
		this.completeDate = completeDate;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

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

	@Column(name = "DESCRIPTION")
	@NotNull
	private String description;

}
