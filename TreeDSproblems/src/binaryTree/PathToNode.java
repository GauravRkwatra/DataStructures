package binaryTree;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PathToNode {
	Node tree;
	 static List<Integer> al = new LinkedList<>();
	    static int arr[] =  new int[al.size()];
	
	static boolean pathToNode(Node root, int tgt) {
		
		if(root==null)
			return false;
		
		if(tgt==root.data) {
			al.add(root.data);
			return true;
		} else {
		
			boolean path = pathToNode(root.left, tgt);	
			
			if(path) {
				
				al.add(root.data);
				return true;
			}
		
					
			boolean right = pathToNode(root.right, tgt);	
			
			if(right) {
				
				al.add(root.data);
				return true;
			}
		}
		return false;
	}
	
	
	
	public static void main(String[] args) {
		PathToNode pn = new PathToNode();
		
		pn.tree = new Node(1);
		
		// 1 Left and Right
		pn.tree.left = new Node(2);
		pn.tree.right = new Node(3);
		
		// 2 Left and Right 
		pn.tree.left.left = new Node(6);
		pn.tree.left.right = new Node(7);
		
		pn.tree.right.left = new Node(4);
		
		pn.tree.right.left.right = new Node(5);
		
		pathToNode(pn.tree, 4);
		System.out.println(al);
		for (int i = 0; i < al.size(); i++) 
	            arr[i] = al.get(i);
		
		System.out.println(Arrays.toString(arr));
	}

}
