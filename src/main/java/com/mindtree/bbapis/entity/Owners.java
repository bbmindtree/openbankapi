package com.mindtree.bbapis.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.ALWAYS)
public class Owners {
	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getProvider() {
		return provider;
	}

	public void setProvider(String provider) {
		this.provider = provider;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	@Override
	public String toString() {
		return "Owners [Id=" + Id + ", provider=" + provider + ", displayName=" + displayName + "]";
	}

	private String Id;
	private String provider;
	private String displayName;

	public Owners() {
		this.Id = null;
		this.provider = null;
		this.displayName = "Savings-john";
	}
}
