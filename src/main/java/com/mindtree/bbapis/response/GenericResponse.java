package com.mindtree.bbapis.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GenericResponse implements Serializable {
	private static final long serialVersionUID = 1L;

	private boolean success;

	private String loginId;

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public boolean isSuccess() {
		return success;
	}

	public void setSuccess(boolean success) {
		this.success = success;
	}

	public GenericResponse(boolean success, String loginId) {
		this.success = success;
		this.loginId = loginId;
	}

	public GenericResponse(boolean success) {
		this.success = success;
	}
}
