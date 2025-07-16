package com.noonwerware.lowestcommonancestor;

public class Node {
	int key;
	Node left;
	Node right;
	
	public Node(int item) {
		key = item;
		left = null;
		right = null; 
	}
	
	
	public String toString() {
		return String.format("Key: %d; left: {%s}; right: {%s}; ancestor: {%s}"
				, key
				, (null != this.left) ? String.valueOf(this.left.key) : "null"
				, (null != this.right) ? String.valueOf(this.right.key) : "null"
		);
	}
}
