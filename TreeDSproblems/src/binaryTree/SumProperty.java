package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SumProperty {

	Node root;
	
	int isSumProperty(Node node) {
		
		if(node==null || (node.left == null && node.right == null))
			return 1;
		else {
			int left_d = 0, right_d = 0;
			
			if(node.left!=null) {
				left_d = left_d + node.left.data;
			}
			
			if(node.right != null) {
				right_d = right_d + node.right.data;
			}
			
			if(node.data == (left_d+right_d) && isSumProperty(node.left)!=0 && isSumProperty(node.right)!=0) {
				return 1;
			} else
				return 0;
		}		
	}
	
	boolean isSumPropert_Itera(Node node) {
		Queue<Node> q = new LinkedList<>();
		q.add(node);
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.left != null && n.right != null) {
				if(n.data != (n.left.data + n.right.data)) {
					return false;
				}
				q.add(n.left);
				q.add(n.right);
			} else if(n.left==null&& n.right!=null) {
				if(n.data != n.right.data)
					return false;
				q.add(n.right);
			} else if(n.left!=null&& n.right==null) {
				if(n.data != n.left.data)
					return false;
				q.add(n.left);
			}		
		}
		return true;
	}
	
	public static void main(String[] args) {

		SumProperty tree = new SumProperty(); 
        tree.root = new Node(10); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(2); 
        tree.root.left.left = new Node(3); 
        tree.root.left.right = new Node(5); 
        tree.root.right.right = new Node(2); 
        if (tree.isSumProperty(tree.root) != 0) 
            System.out.println("The given tree satisfies children"
                    + " sum property"); 
        else
            System.out.println("The given tree does not satisfy children"
                    + " sum property"); 
        
        if (tree.isSumPropert_Itera(tree.root)) 
            System.out.println("The given tree satisfies children"
                    + " sum property_itera"); 
        else
            System.out.println("The given tree does not satisfy children"
                    + " sum property!!1!!!!!!!!!"); 
	}

}
