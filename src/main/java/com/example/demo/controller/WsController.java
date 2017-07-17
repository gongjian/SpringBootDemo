package com.example.demo.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.example.demo.model.WsMessage;
import com.example.demo.model.WsResponse;

@Controller
public class WsController {

	@Autowired
	private SimpMessagingTemplate messagingTemplate;

	@MessageMapping("/welcome")
	@SendTo("/topic/getResponse")
	public WsResponse say(WsMessage message) throws Exception {
		Thread.sleep(3000);

		return new WsResponse("Welcome " + message.getName() + "!");
	}

	@MessageMapping("/chat")
	public void handleChat(Principal principal, String msg) {
		
		System.out.println(">>>>>> msg: " + msg);
		
		if (principal.getName().equals("gongjian1")) {
			messagingTemplate.convertAndSendToUser("gongjian2", "/queue/notifications",
					principal.getName() + "-send: " + msg);
		} else {
			messagingTemplate.convertAndSendToUser("gongjian1", "/queue/notifications",
					principal.getName() + "-send: " + msg);
		}

	}

}
