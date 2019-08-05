package com.prac.angular.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import com.google.common.base.Function;
import com.google.common.collect.Maps;
import com.prac.angular.entity.PhoneEntity;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamTest {
	@Test
	public void test() {
		List<String> list = Arrays.asList("a", "b", "c", "c1", "c2", "d");
		list.stream().filter(e -> e.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);

		List<String> streamList = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		streamList.stream().forEach(System.out::println);
		System.out.println("========================");
		Stream.of("a1", "a2", "a3", "a4").findFirst().ifPresent(System.out::println);
		PhoneEntity phone = new PhoneEntity();
		PhoneEntity phone1 = new PhoneEntity();
		phone.setPhoneNumber("010-1234-1234");
		phone1.setPhoneNumber("010-1231-1231");
		
		List<PhoneEntity> phoneList = Arrays.asList(phone, phone1);
		
		Map<String, PhoneEntity> map = makeMap(phoneList);
		System.out.println("guaba map 확인: "+map);
	}
	
	public Map<String, PhoneEntity> makeMap(List<PhoneEntity> list){
		return Maps.uniqueIndex(list, new Function<PhoneEntity, String>(){
			@Override
			public String apply(PhoneEntity str) {
				return str.getPhoneNumber();
			}
		});
	}
}
