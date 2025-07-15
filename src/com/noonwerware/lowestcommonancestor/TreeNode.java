package com.noonwerware.lowestcommonancestor;

public class TreeNode {
	int key;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int item) {
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
