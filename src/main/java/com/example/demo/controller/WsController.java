package com.example.demo.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import com.example.demo.model.WsMessage;
import com.example.demo.model.WsResponse;

@Controller
public class WsController {
	
	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WsResponse say(WsMessage message) throws Exception {
		Thread.sleep(3000);
		
		return new WsResponse("Welcome " + message.getName() + "!");
	}

}
