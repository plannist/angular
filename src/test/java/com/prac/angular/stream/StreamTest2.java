package com.prac.angular.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.*;
import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class StreamTest2 {
	@Test
	public void test() {
		List<String> list = Arrays.asList("a1", "b", "c", "c2", "d2", "e");
		List<String> streamList = list.stream().filter(e -> e.startsWith("c")).map(String::toUpperCase).collect(Collectors.toList());
		log.debug("streamList 확인: {}", streamList);
		
		//여기서 알게된 2가지 collect 메서드로 일반 list, map, set으로 변환가능하고 log.debug의 {} 괄호로 리스트 내용 배열형식으로 출력가능.
		List<String> streamMakeList = Stream.of("a1", "a2", "a4", "a3").sorted().collect(Collectors.toList());
		log.debug("Stream.of.sorted 확인: {}", streamMakeList);
	}
}
