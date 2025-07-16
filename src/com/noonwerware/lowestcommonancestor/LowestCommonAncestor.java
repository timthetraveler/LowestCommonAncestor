package com.noonwerware.lowestcommonancestor;

public class LowestCommonAncestor {

	BinarySearchTree tree = new BinarySearchTree();

	public static void main(String[] args) {
		LowestCommonAncestor thisClass = new LowestCommonAncestor();
		thisClass.doIt();
	}
	
	void doIt() {
		tree.insert(8);
		tree.insert(3);
		tree.insert(10);
		tree.insert(1);
		tree.insert(6);
		tree.insert(4);
		tree.insert(9);
		tree.insert(14);
		tree.insert(13);
		
//		findLeastCommonAncestor(8, 8);
//		findLeastCommonAncestor(8, 3);
//		findLeastCommonAncestor(8, 10);
//		findLeastCommonAncestor(8, 1);
//		findLeastCommonAncestor(8, 6);
//		findLeastCommonAncestor(8, 4);
//		findLeastCommonAncestor(8, 9);
//		findLeastCommonAncestor(8, 14);
//		findLeastCommonAncestor(8, 13);

//		findLeastCommonAncestor(3, 3);
//		findLeastCommonAncestor(3, 10);
//		findLeastCommonAncestor(3, 1);
//		findLeastCommonAncestor(3, 6);
//		findLeastCommonAncestor(3, 4);
//		findLeastCommonAncestor(3, 9);
//		findLeastCommonAncestor(3, 14);
//		findLeastCommonAncestor(3, 13);

//		findLeastCommonAncestor(10, 10);
//		findLeastCommonAncestor(10, 1);
//		findLeastCommonAncestor(10, 6);
//		findLeastCommonAncestor(10, 4);
//		findLeastCommonAncestor(10, 9);
//		findLeastCommonAncestor(10, 14);
//		findLeastCommonAncestor(10, 13);
	
//		findLeastCommonAncestor(1, 1);
//		findLeastCommonAncestor(1, 6);
//		findLeastCommonAncestor(1, 4);
//		findLeastCommonAncestor(1, 9);
//		findLeastCommonAncestor(1, 14);
//		findLeastCommonAncestor(1, 13);
	
//		findLeastCommonAncestor(6, 6);
//		findLeastCommonAncestor(6, 4);
//		findLeastCommonAncestor(6, 9);
//		findLeastCommonAncestor(6, 14);
//		findLeastCommonAncestor(6, 13);

//		findLeastCommonAncestor(4, 4);
//		findLeastCommonAncestor(4, 9);
//		findLeastCommonAncestor(4, 14);
//		findLeastCommonAncestor(4, 13);

//		findLeastCommonAncestor(9, 9);
//		findLeastCommonAncestor(9, 14);
//		findLeastCommonAncestor(9, 13);

//		findLeastCommonAncestor(14, 14);
//		findLeastCommonAncestor(14, 13);
		
		isBinarySearchTree();
}

	void findIt(int key) {
		Node foundNode = tree.find(key);
		if (null != foundNode) {
			System.out.println(String.format("%d found %s", key, foundNode.toString()));
		}
		else {
			System.out.println(String.format("%d found %s", key, "not found"));
		}
	}
	
	void findLeastCommonAncestor(int n1, int n2) {
		Node leastCommonAncestor = tree.findLeastCommonAncestor(n1, n2);
		System.out.println(String.format("The least common ancestor of %d and %d is %s", n1, n2
				, (null != leastCommonAncestor) ?  leastCommonAncestor.key : "none"));
	}

	void isBinarySearchTree() {
		System.out.println(String.format("Is tree a binary search tree %b", isBinarySearchTree(tree.root)));
	}
	
	boolean isBinarySearchTree(Node parentNode) {
		int key = parentNode.key;
		if (null != parentNode.left) {
			int leftKey = parentNode.left.key;
			if ((leftKey > key) || (!isBinarySearchTree(parentNode.left))) {
				return false;
			}
		}

		if (null != parentNode.right) {
			int rightKey = parentNode.right.key;
			if ((rightKey < key) || (!isBinarySearchTree(parentNode.right))) {
				return false;
			}
		}
		return true;
	}
}
