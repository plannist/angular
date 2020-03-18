package com.prac.angular.kafka;

import java.time.LocalDateTime;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ScheduleForKafka {
	@Autowired
    private KafkaTemplate kafkaTemplate;
	
	public void send(String topic, String payload) {
        kafkaTemplate.send(topic, payload);
        log.info("Message: " + payload + " sent to topic: " + topic);
    }
	
	@Scheduled(fixedRate = 1000)
    public void reportCurrentTime() {
        send("test", "helloworld " + LocalDateTime.now());
    }

    @KafkaListener(topics = "PJS")
    public void receiveTopic1(ConsumerRecord consumerRecord) {
        log.info("Receiver on topic1: "+consumerRecord.toString());
    }
	
}
