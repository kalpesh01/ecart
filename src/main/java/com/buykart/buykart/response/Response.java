package com.buykart.buykart.response;

import java.io.Serializable;

public class Response implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6901690026661941489L;

	private String message;

	private Object data;

	private boolean status;

	
	
	public Response(String message, Object data, boolean status) {
		super();
		this.message = message;
		this.data = data;
		this.status = status;
	}

	
	public Response() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
