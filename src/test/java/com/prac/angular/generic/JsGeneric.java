package com.prac.angular.generic;

public interface JsGeneric<K, V> {
	public void put(K key, V value);
	public V get(K key);
}
