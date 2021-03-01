package binaryTree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class DiagonalTreeRecur {

	public static void main(String[] args) {

		Node root = new Node(8);
        root.left = new Node(3);
        root.right = new Node(10);
        root.left.left = new Node(1);
        root.left.right = new Node(6);
        root.right.right = new Node(14);
        root.right.right.left = new Node(13);
        root.left.right.left = new Node(4);
        root.left.right.right = new Node(7);
         
        diagonalPrint(root);
	}

	static void diagonalPrint(Node root) {
		
		if (root==null) {
			return;
		}
		
		diagonalPrintUtil(root, 0);
		
		for(Entry<Integer, List<Integer>> m : map.entrySet()) {
			System.out.println(m);
		}
		
	}
	static Map<Integer, List<Integer>> map = new HashMap<>();
	
	static void diagonalPrintUtil(Node root, int d) {
		
		if(root==null)
			return;
		
		List<Integer> list = map.get(d);
		if(list!=null) {
			list.add(root.data);
		} else {
			list = new ArrayList<>();
			list.add(root.data);
			map.put(d, list);
		}
		
		diagonalPrintUtil(root.left, d+1);
		diagonalPrintUtil(root.right, d);
	}
	

}
