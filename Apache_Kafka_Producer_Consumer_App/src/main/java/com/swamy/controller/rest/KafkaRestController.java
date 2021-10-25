package com.swamy.controller.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.swamy.producer.KafkaProducer;
import com.swamy.storage.MessageStorage;

@RestController
@RequestMapping("/kafka")
public class KafkaRestController {

	@Autowired
	private KafkaProducer kafkaProducer;
	
	@Autowired
	private MessageStorage messageStorage;
	
	//Producer API
	@GetMapping("/send/{message}")
	public String readMsg(@PathVariable String message) {
		kafkaProducer.send(message);
		System.out.println(message);
		return "message sent successfully..!";
	}
	
	//Consumer-API
	@GetMapping("/consume")
	public String consumeDataFromProducer() {
		return messageStorage.readInfo();
	}
}

