package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class PrintCorner {
	Node root;
	
	private void leftNRight() {
		
		Queue<Node> q = new LinkedList<>();
		q.add(root);
		while(!q.isEmpty()) {
			
			int queSize = q.size();
			
			for(int i=0; i< queSize; ++i) {
				Node temp = q.poll();
				
				if(i==0 || i == queSize-1) {
					System.out.println(temp.data+" ");
				}
				
				if(temp.left!=null) {
					q.add(temp.left);
				}
				
				if(temp.right!=null) {
					q.add(temp.right);
				}
			}
		}
	}

	public static void main(String[] args) {

		PrintCorner tree = new PrintCorner();
		
		tree.root = new Node(15); 
        tree.root.left = new Node(10); 
        tree.root.right = new Node(20); 
        tree.root.left.left = new Node(8); 
        tree.root.left.right = new Node(12); 
        tree.root.right.left = new Node(16); 
        tree.root.right.right = new Node(25); 
        
        tree.leftNRight();
	}

}
