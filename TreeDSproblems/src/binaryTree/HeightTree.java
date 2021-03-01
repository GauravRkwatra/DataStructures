package binaryTree;

public class HeightTree {
	Node root;
	
	int heightTree(Node root) {
		
		if(root==null) {
			// -1 for edges count, 0 for nodes count
			return -1;
		} else { 			
		    int left = heightTree(root.left);
		    int right = heightTree(root.right);
		    return Math.max(left, right) + 1;
		}
	}
	
	public static void main(String[] args) {
		
		HeightTree tree = new HeightTree();
		
		tree.root = new Node(1);
		
		tree.root.left = new Node(2);
                tree.root.right = new Node(3);
        
        	// 2 Left and right
        	tree.root.left.left = new Node(4);
        	tree.root.left.right = new Node(5);
		
        	int height = tree.heightTree(tree.root);
        	System.out.println("Height: "+height);
	}

}
