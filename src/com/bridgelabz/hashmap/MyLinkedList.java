package com.bridgelabz.hashmap;


public class MyLinkedList<K> {
	private INode head;
	private INode tail;
	
	public MyLinkedList() {
		this.head = null;
		this.tail = null;
	}
	
	public void add(INode myNode) {
		
		if(head == null) {
			head = myNode;
		}
		if (tail == null) {
			tail = myNode;
		}else {
			INode tempNode = head;
			head = myNode;
			head.setNext(tempNode);
		}
	}
	
	public void append(INode myNode) {
		if(head==null) {
			head=myNode;
		}if(tail==null) {
			tail=myNode;
		}else {
			tail.setNext(myNode);
			tail=myNode;	
		}
		
	}

	
	public void delete(K myNode) {
		INode<K> tempNode = this.head;
		while(tempNode != null) {
			if(tempNode.getNext().getKey().equals((K)myNode)) {
				INode<K> temp = tempNode.getNext().getNext();
				tempNode.setNext(temp);
				break;
			}
			tempNode = tempNode.getNext();
		}
	}
	
	public INode search(K key) {
		INode tempNode = head;
		while (tempNode != null) {
			if(tempNode.getKey().equals((K)key)) {
				return tempNode;
			}
			tempNode = tempNode.getNext();
		}
		return null;
	}
	
	public void printMyNodes() {
		System.out.println("My Nodes :" +head);
	}
	
	
	
	@Override
	public String toString() {
		return "MyLinkedList [head=" + head + "]";
	}

	public void print() {
		INode tempNode = head;
		
		while(tempNode != null) {
			System.out.println(tempNode.getKey());
			tempNode = tempNode.getNext();
		}
	}
}