package com.mindtree.bbapis.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "CUSTOMER")
public class Customer {
	@Id
	@Column(name = "ID", length = 10)
	private String id;

	@Column(name = "CUSTOMER_NAME", length = 50)
	@NotNull
	private String name;

	@Column(name = "CUSTOMER_EMAIL", length = 30, unique = true)
	@NotNull
	@Size(min = 12, max = 30)
	private String emailId;

	@Column(name = "CUSTOMER_PASSWORD", length = 100)
	@NotNull
	private String password;

	@Column(name = "MOBILE", length = 10, unique = true)
	@NotNull
	private String mobile;

	@Column(name = "DOB", length = 10)
	@NotNull
	private String dob;

	@Column(name = "ENABLED")
	@NotNull
	private Boolean enabled;

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}
}
