package com.mindtree.bbapis.dao;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ACCOUNTS")
public class AccountDAO {

	@Id
	@Column(name = "ACCOUNT_NUMBER", length = 12, unique = true)
	private String accountNumber;

	@Column(name = "ID", length = 45, unique = true)
	@NotNull
	private String Id;

	@Column(name = "ACCOUNT_LABEL", length = 45)
	@NotNull
	private String label;

	@Column(name = "ACCOUNT_TYPE", length = 10)
	@NotNull
	private String type;

	@Column(name = "IBAN", length = 34)
	@NotNull
	@Size(min = 12, max = 34)
	private String IBAN;

	@Column(name = "SWIFT_BIC", length = 45)
	@NotNull
	@Size(min = 12, max = 45)
	private String swift_bic;

	@Column(name = "BANKING_ID", length = 45)
	@NotNull
	@Size(min = 12, max = 45)
	private String banking_id;

	@Column(name = "CURRENCY")
	@NotNull
	private String currency;

	@Column(name = "ACCOUNT_BALANCE")
	@NotNull
	private Double amount;

	@Column(name = "USERID")
	@NotNull
	private String userId;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		this.Id = id;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getIBAN() {
		return IBAN;
	}

	public void setIBAN(String iBAN) {
		IBAN = iBAN;
	}

	public String getSwift_bic() {
		return swift_bic;
	}

	public void setSwift_bic(String swift_bic) {
		this.swift_bic = swift_bic;
	}

	public String getBanking_id() {
		return banking_id;
	}

	public void setBanking_id(String banking_id) {
		this.banking_id = banking_id;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public AccountDAO() {
		this.Id = String.valueOf(UUID.randomUUID());
	}

}
