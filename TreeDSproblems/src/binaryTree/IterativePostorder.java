package binaryTree;

import java.util.Stack;

public class IterativePostorder {

	Node root;
	Stack<Node> s1, s2;
	
	void postOrder(Node root) {
		if(root==null)
			return;
		
		s1 = new Stack<Node>();
		s2 = new Stack<Node>();
		
		s1.add(root);
		
		while(!s1.empty()) {
			Node node = s1.pop();
			
			s2.push(node);
			
			if(node.left!=null)
				s1.push(node.left);
			
			if(node.right!=null)
				s1.push(node.right);
		}
		while (!s2.empty()) {
			System.out.print(s2.pop().data+" ");
			
		}
	}
	
	void postOrder() {  postOrder(root);  } 
	
	public static void main(String[] args) {
		
		IterativePostorder tree= new IterativePostorder();
		tree.root = new Node(1); 
		tree.root.left = new Node(2); 
		tree.root.right = new Node(3); 
		tree.root.left.left = new Node(4); 
		tree.root.left.right = new Node(5); 
		tree.root.right.left = new Node(6); 
		tree.root.right.right = new Node(7); 
		
		tree.postOrder();
	}

}
