package binarySearchTree;

public class Node {

	int val;
	Node left, right;
	
	public Node(int data) {
		this.val = data;
		left = right = null;
	}
	@Override
	public String toString() {
		return "Node [data=" + val + ", left=" + left + ", right=" + right + "]";
	}
}
