package com.prac.angular.kafka;

import java.util.Properties;


import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Order(1)
@Component
public class Producer implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		Properties props = new Properties();
		props.put("bootstrap.servers", "175.118.126.12:9092");
		props.put("acks", "all");
		props.put("retries", 0);
		props.put("batch.size", 16384);
		props.put("linger.ms", 1);
		props.put("buffer.memory", 33554432);
		props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");
		
		  KafkaProducer kafkaProducer = new KafkaProducer(props);
	        try{
	            for(int i = 0; i < 100; i++){
	                System.out.println(i);
	                kafkaProducer.send(new ProducerRecord("PJS", Integer.toString(i), "test message - " + i ));
	            }
	        }catch (Exception e){
	            e.printStackTrace();
	        }finally {
	            kafkaProducer.close();
	        }
		 
		 
	}

}
