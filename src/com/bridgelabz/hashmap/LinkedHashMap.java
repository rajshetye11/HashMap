package com.bridgelabz.hashmap;

import java.util.ArrayList;

public class LinkedHashMap<K, V> {
	private final int buckets;
	ArrayList<MyLinkedList<K>> bucketArray;
	
	public LinkedHashMap() {
		this.buckets = 10;
		this.bucketArray = new ArrayList<>(buckets);
	
		for(int i=0;i<buckets;i++) {
			this.bucketArray.add(null);
		}
	}
	
	private int getBucketIndex(K key) {
		int hashcode = (Math.abs(key.hashCode()));
		int index = hashcode % buckets;
		return index;
	}

	public V get(K key) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.bucketArray.get(index);
		if(myLinkedList == null) return null;
		MyMapNode<K,V> myMapNode = (MyMapNode<K,V>) myLinkedList.search(key);
		return (myMapNode == null) ? null : myMapNode.getValue();
	}

	public void add(K key,V value) {
		int index = this.getBucketIndex(key);
		MyLinkedList<K> myLinkedList = this.bucketArray.get(index);
		if(myLinkedList == null) {
			myLinkedList = new MyLinkedList<>();
			this.bucketArray.set(index, myLinkedList);
			}
		MyMapNode<K,V> myMapNode = (MyMapNode<K,V>) myLinkedList.search(key);
		if(myMapNode == null) {
			myMapNode = new MyMapNode<>(key,value);
			myLinkedList.append(myMapNode);
		}
		else {
			myMapNode.setValue(value);
		}
	}
	
	@Override
	public String toString() {
		return "MyLinkedHashMap {"+ bucketArray +"}";
		
	}
	
}