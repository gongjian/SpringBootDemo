package com.example.demo.model;

public class WsResponse {

	private String responseMessage;

	public WsResponse() {
	}

	public WsResponse(String message) {
		this.responseMessage = message;
	}

	public String getResponseMessage() {
		return responseMessage;
	}

	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}

}
