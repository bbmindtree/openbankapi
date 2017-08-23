package com.mindtree.bbapis.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class AccountRouting {
	public String getScheme() {
		return scheme;
	}

	public void setScheme(String scheme) {
		this.scheme = scheme;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "AccountRouting [scheme=" + scheme + ", address=" + address + "]";
	}

	private String scheme;
	private String address;

	public AccountRouting() {
		this.scheme = null;
		this.address = null;
	}
}
