package com.bridgelabz.hashmap;

public class MyHashMap<K,V> {

	MyLinkedList<K> linkedlist;
	
	public MyHashMap() {
		this.linkedlist = new MyLinkedList<>();
	}

	public V get(K key) {
		MyMapNode<K,V> mymapnode = (MyMapNode<K,V>) this.linkedlist.search(key);
		return (mymapnode == null) ? null : mymapnode.getValue();

	}

	public void add(K key, V value) {
		MyMapNode<K,V> mymapnode = (MyMapNode<K,V>) this.linkedlist.search(key);
		if (mymapnode == null) {
			mymapnode = new MyMapNode<>(key, value);
			this.linkedlist.append(mymapnode);
		}
		else {
			mymapnode.setValue(value);
		}
	}
	
	@Override
	public String toString() {
		return "MyHashMapNodes {" +linkedlist+ "}";
	}
}