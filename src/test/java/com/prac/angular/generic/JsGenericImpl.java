package com.prac.angular.generic;

public class JsGenericImpl<K, V> implements JsGeneric<K, V> {

	public K key;
	public V value;
	Node<K, V> node[] = new Node[100];
	int length;
	
	@Override
	public void put(K key, V value) {
		System.out.println("length: "+length+", key: "+key+", value: "+value);
		node[length] = new Node<K, V>(length, key, value);
		length++;
	}

	@Override
	public V get(K key) {
		for(int i=0; i<node.length; i++) {
			if(key == node[i].key) {
				return node[i].value;
			}
		}
		return null;
	}
	
	static class Node<K, V>{
		int hash;
		K key;
		V value;
		Node<K, V> next;
		
		Node(int hash, K key, V value){
			this.hash = hash;
			this.key = key;
			this.value = value;
		}
		
		public final K getKey() {
			return key;
		}
		
		public final V getValue() {
			return value;
		}
		
		public final V setValue(V newValue) {
			V oldValue = value;
			value = newValue;
			return oldValue;
		}
		
		public void setAll(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
	}

}
