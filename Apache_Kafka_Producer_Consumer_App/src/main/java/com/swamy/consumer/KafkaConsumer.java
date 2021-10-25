package com.swamy.consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.swamy.storage.MessageStorage;

@Component
public class KafkaConsumer {

	@Autowired
	private MessageStorage messageStorage;
	
	@KafkaListener(topics = "${kafka-topic-name}",groupId = "group-id")
	public void readData(String message) {
		messageStorage.put(message);
	}
}









