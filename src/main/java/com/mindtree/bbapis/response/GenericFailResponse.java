package com.mindtree.bbapis.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class GenericFailResponse extends GenericResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private String error;

	public GenericFailResponse(String error) {
		super(Boolean.FALSE);
		this.error = error;
	}

	public String getError() {
		return error;
	}

}
