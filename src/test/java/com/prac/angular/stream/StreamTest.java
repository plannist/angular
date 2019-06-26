package com.prac.angular.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class StreamTest {
	@Test
	public void test() {
		List<String> list = Arrays.asList("a", "b", "c", "c1", "c2", "d");
		list.stream().filter(e -> e.startsWith("c")).map(String::toUpperCase).sorted().forEach(System.out::println);
		
		List<String> streamList = list.stream().map(String::toUpperCase).collect(Collectors.toList());
		streamList.stream().forEach(System.out::println);
		System.out.println("========================");
		Stream.of("a1", "a2", "a3", "a4").findFirst().ifPresent(System.out::println);
	}
}
