package binaryTree;

import java.util.LinkedList;
import java.util.List;

public class LeftViewBinaryTree {
	
	Node root;
	int maxLevel = 0;
	List<Integer> list = new LinkedList<>();
	
	public List<Integer> leftViewRecur(Node node, int nodeLevel) {
	
		if(node==null)
		   return list;
		
		System.out.println("Node: "+node.data+" -Node-Level: "+nodeLevel+" > maxLevel "+maxLevel);
		
		// If this is the first node of its level
		if(nodeLevel > maxLevel) {
			list.add(node.data);
			maxLevel = nodeLevel;
		}
		
		// Recursive call for left and right nodes
		leftViewRecur(node.left, nodeLevel + 1);
		leftViewRecur(node.right, nodeLevel + 1);
		
		return list;	
	}
	
	public static void main(String[] args) {

		LeftViewBinaryTree lv = new LeftViewBinaryTree();
		lv.root = new Node(12);
		
		lv.root.left = new Node(10);
		lv.root.right = new Node(30);
		
		lv.root.left.left = new Node(15);
		
		lv.root.right.left = new Node(25);
		lv.root.right.right = new Node(40);
		
		List<Integer> l = lv.leftViewRecur(lv.root, 1);
		 System.out.println("Recursion: "+l);
	}

}
