package com.prac.angular.generic;

import org.junit.Test;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class JenericTestStarter {
	@Test
	public void test() {
		JsGeneric<String, Object> generic = new JsGenericImpl<>();
		generic.put("key", "value");
		generic.put("key1", "value1");
		generic.put("key2", "value2");
		generic.put("key3", "value3");
		generic.put("key4", "value4");
		
		log.debug("go Get: {}", generic.get("key3"));
	}
}
