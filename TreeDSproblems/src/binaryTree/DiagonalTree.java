package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class DiagonalTree {

	static void diagonalPrint(Node root) {
	
		if(root==null)
			return;
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		q.add(null);
		
		while(!q.isEmpty()) {
			Node p = q.poll();
		
			if(p==null) {
				System.out.println();
				if(q.isEmpty())
					break;
				q.add(null);
			} else {
				while(p!=null) {
					System.out.print(p.data+" ");
					if(p.left!=null)
						q.add(p.left);
					p = p.right;
				}
			}
			
		}
	}
	
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

}
