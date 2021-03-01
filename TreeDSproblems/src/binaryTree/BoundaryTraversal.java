package binaryTree;

public class BoundaryTraversal {

	Node root;
	
	void printLeaves(Node node) {
		
		if(node==null)
			return;
		printLeaves(node.left);
		if(node.left==null && node.right==null)
			System.out.println(node.data+" -Leaf");
		printLeaves(node.right);
	}
	
	void printBoundaryLeft(Node node) {
	
		if(node==null)
			return;
		
		if(node.left!=null) {
			System.out.println(node.data+" -Left");
			printBoundaryLeft(node.left);
		} else if (node.right !=null){
			System.out.println("Change");
			System.out.println(node.data+ " -Right-LL");
			printBoundaryLeft(node.right);
		} else {
			// do nothing if it is a leaf node, this way we avoid 
	        // duplicates in output 
		}
	}
	
	void printBoundaryRight(Node node) {
		
		if (node==null)
			return;
		
		if(node.right!=null) {
			printBoundaryRight(node.right); 
            System.out.println(node.data + " -Right"); 
		} else if (node.left!=null){
			printBoundaryRight(node.left); 
            System.out.println(node.data + " -Left-RR"); 
		} else {
			// do nothing if it is a leaf node, this way we avoid 
	        // duplicates in output 
		}
	}
	
	void printBoundary(Node node) {
		
		if(node==null)
			return;
		
		System.out.println(node.data+" -Root");
		
		printBoundaryLeft(node.left);
		
		printLeaves(node.left);
		printLeaves(node.right);
		
		printBoundaryRight(node.right);
	}
	
	public static void main(String[] args) {
		BoundaryTraversal tree= new BoundaryTraversal();
		 tree.root = new Node(20); 
	     tree.root.left = new Node(8); 
	     tree.root.left.left = new Node(4);
	     tree.root.left.right = new Node(12); 
	     tree.root.left.right.left = new Node(10); 
	     tree.root.left.right.right = new Node(14); 
	     tree.root.right = new Node(22); 
	     tree.root.right.right = new Node(25); 
	     tree.root.right.right.right = new Node(52); 
	     tree.printBoundary(tree.root); 
		
	}

}
