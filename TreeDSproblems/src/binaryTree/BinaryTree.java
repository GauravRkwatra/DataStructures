package binaryTree;

public class BinaryTree {

	Node root;
	
	void levelOrder (Node node) {
		if(node==null)
			return;
		
		
	}
	void postOrder(Node node) {
		
		if(node==null)
			return;
		
		postOrder(node.left);		
		postOrder(node.right);		
		System.out.print(node.data+" ");
	}
	
	void preOrder(Node node) {
		if(node==null)
			return;
		
		System.out.print(node.data+" ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	void inOrder(Node node) {
		if(node==null)
			return;
		
		inOrder(node.left);
		System.out.print(node.data+" ");
		inOrder(node.right);
			
	}
	 
	// Wrappers over above recursive functions 
    void postOrder()  {     postOrder(root);  } 
    void inOrder()    {     inOrder(root);   } 
    void preOrder()   {     preOrder(root);  } 
    
	public static void main(String[] args) {
		

		BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        
        System.out.println("Preorder traversal of binary tree is "); 
        tree.preOrder(); 
  
        System.out.println("\nInorder traversal of binary tree is "); 
        tree.inOrder(); 
  
        System.out.println("\nPostorder traversal of binary tree is "); 
        tree.postOrder(); 
	}

}
