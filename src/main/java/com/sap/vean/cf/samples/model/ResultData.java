package com.sap.vean.cf.samples.model;

public class ResultData {

	private boolean success;
	private String message = "";
	private Object resultobject;
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Object getResultobject() {
		return resultobject;
	}
	public void setResultobject(Object resultobject) {
		this.resultobject = resultobject;
	}
	
	
	
}
