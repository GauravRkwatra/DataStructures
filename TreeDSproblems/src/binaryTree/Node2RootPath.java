package binaryTree;

public class Node2RootPath {
	Node root;
	
	Node findNodeToRoot(Node node, int val) {
		
		if(node==null)
			return null;
		
		if(val==node.data) {
			System.out.println(""+node.data);
			// It's compulsory to return node from here
			// other all parent nodes get null instead of path
			return node;
		}
		
		Node left = findNodeToRoot(node.left, val);
	
		if(left!=null) {
			System.out.println(""+node.data);
			return left;
		}
		Node right = findNodeToRoot(node.right, val);
		
		if(right!=null) {
			System.out.println(""+node.data);
			return right;
		}
		return null;	
		
		
		// Above lines from 24 to 30 can be 
		// replace with single line
		// return findNodeToRoot(node.right, val);
	}
	
	public static void main(String[] args) {
		Node2RootPath np = new Node2RootPath();

		np.root = new Node(50);
		
		np.root.left = new Node(25);
		np.root.right = new Node(75);
		
		// Left and Right of 25
		np.root.left.left = new Node(12);
		np.root.left.right = new Node(37);
		
		// Left and Right of 75
		np.root.right.left = new Node(62);
		np.root.right.right = new Node(87);
				
		// Left and Right of 37
		np.root.left.right.left = new Node(30);
		np.root.left.right.right = new Node(40);
		
		// Left and Right of 62		
		np.root.right.left.left = new Node(60);
		np.root.right.left.right = new Node(70);
		
		np.findNodeToRoot(np.root, 70);
	}

}
