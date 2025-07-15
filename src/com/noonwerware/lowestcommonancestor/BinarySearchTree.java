package com.noonwerware.lowestcommonancestor;

public class BinarySearchTree {
	TreeNode root;
	
	public BinarySearchTree() {
		root = null;
	}
	
	void insert(int key) {
		root = insertNode(root, key, null);
	}
	
	TreeNode insertNode(TreeNode root, int key, TreeNode ancestor) {
		if (null == root) {
			root = new TreeNode(key);
			return root;
		}
		
		if (key < root.key) {
			root.left = insertNode(root.left, key, root);
		}
		else if (key > root.key) {
			root.right = insertNode(root.right, key, root);
		}
		return root;
	}
	
	void delete(int key) {
		root = deleteNode(root, key);
	}
	
	TreeNode deleteNode(TreeNode root, int key) {
		if (null == root) {
			return root;
		}
		
		if (key < root.key) {
			root.left = deleteNode(root.left, key);
		}
		else if (key > root.key) {
			root.right = deleteNode(root.right, key);
		}
		else {
			if (null == root.left) {
				return root.right;
			}
			else if (null == root.right) {
				return root.left;
			}
			
			root.key = minValue(root.right);
			root.right = deleteNode(root.right, root.key);
		}
		return root;
	}
	
	int minValue(TreeNode root) {
		int minValue = root.key;
		while (root.left != null) {
			minValue = root.left.key;
			root = root.left;
		}
		return minValue;
	}

	boolean search(int key) {
		if (null != find(key)) {
			return true;
		}
		return false;

	}
	
	boolean searchTree(TreeNode root, int key) {
		if (null == root) {
			return false;
		}
		
		if (key == root.key) {
			return true;
		}

		if (key > root.key) {
			return searchTree(root.right, key);
		}

		return searchTree(root.left, key);
	}
	
	TreeNode find(int key) {
		if (null == root) {
			return null;
		}
		
		if (key == root.key) {
			return root;
		}
		
		if (key > root.key) {
			return findNode(root.right, key);			
		} 
		return findNode(root.left, key);
		
	}
	
	TreeNode findNode(TreeNode root, int key) {
		if (null == root) {
			return null;
		}
		
		if (key == root.key) {
			return root;
		}

		if (key > root.key) {
			return findNode(root.right, key);
		}

		return findNode(root.left, key);
		
	}
	
	TreeNode findLeastCommonAncestor(int n1, int n2) {
		if ((null == root) || (!search(n1)) || (!search(n2))) {
			return null;
		}

		if (n1 == n2) {
			//
			// Both are the same node.  Return its ancestor.
			//
			TreeNode foundNode = find(n1);
			return foundNode;
		}
		
		TreeNode n1Node = find(n1);
		TreeNode n2Node = find(n2);
		
		if ((root.key == n1Node.key) || (root.key == n2Node.key)) {
			//
			// This is the least common ancestor
			//
			return root;
		}

		if (isRight(root, n1Node)) {
			if (isRight(root, n2Node)) {
				return findLeastCommonAncestor(root.right, n1Node, n2Node);
			}
		}
		else if (!isRight(root, n2Node)) {
			return findLeastCommonAncestor(root.left, n1Node, n2Node);
		}
		return root;
	}
	
	TreeNode findLeastCommonAncestor(TreeNode root, TreeNode n1Node, TreeNode n2Node) {
		if (null == root) {
			return null;
		}
		
		if ((root.key == n1Node.key) || (root.key == n2Node.key)) {
			//
			// This is the least common ancestor
			//
			return root;
		}
		
		if (isRight(root, n1Node)) {
			if (isRight(root, n2Node)) {
				return findLeastCommonAncestor(root.right, n1Node, n2Node);
			}
		}
		else if (!isRight(root, n2Node)) {
			return findLeastCommonAncestor(root.left, n1Node, n2Node);
		}
		
		return root;
	}
	
	boolean isRight(TreeNode root, TreeNode node) {
		if (null == root) {
			return false;
		}
		
		if (node.key == root.key) {
			return false;
		}
		
		if (node.key > root.key) {
			return true;
		}
		
		return false;
	}
}
