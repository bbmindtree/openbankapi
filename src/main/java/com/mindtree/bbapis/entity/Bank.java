package com.mindtree.bbapis.entity;

public class Bank {
	private String national_identifier;
	private String name;

	public String getNational_identifier() {
		return national_identifier;
	}

	public void setNational_identifier(String national_identifier) {
		this.national_identifier = national_identifier;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Bank() {
		this.national_identifier = "OBP";
		this.name = "OBP";
	}

}
