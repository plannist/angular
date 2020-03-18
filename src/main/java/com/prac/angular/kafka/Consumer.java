package com.prac.angular.kafka;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Order(2)
@Slf4j
@Component
public class Consumer implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		Properties props = new Properties();
		
		props.put("bootstrap.servers", "175.118.126.12:9092");
		props.put("group.id", "PJS");
		props.put("auto.commit.interval.ms", "1000");
		props.put("session.timeout.ms", "30000");
		props.put("key.deserializer", "org.apache.kafka.common.serializa-tion.StringDeserializer");
		props.put("value.deserializer", "org.apache.kafka.common.serializa-tion.StringDeserializer");
		
		KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(props);
		List<String> topics = new ArrayList<>();
		topics.add("PJS");
		consumer.subscribe(topics);
		try {
			while(true) {
				ConsumerRecords<String, String> records = consumer.poll(10);
				for(ConsumerRecord<String, String> record : records) {
					log.debug("Topic: "+record.topic()+", partition: "+record.partition()+", value: "+record.value());
				}
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			consumer.close();
		}
		
	}

}
