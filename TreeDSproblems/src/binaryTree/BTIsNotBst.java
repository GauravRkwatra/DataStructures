package binaryTree;

public class BTIsNotBst {

	Node root, prev;
	
	boolean isBST(Node node) {
		System.out.println("------------------------------------------");
		System.out.println("Node: "+node);
		if (node != null) { 
            if (!isBST(node.left)) 
                return false; 
  
            if (prev != null && node.data <= prev.data ) 
                return false; 
            
            System.out.println("Before Prev: "+prev);
            prev = node; 
            System.out.println("After Prev: "+prev);
            
            return isBST(node.right); 
        } 
        return true; 
	}
	
	public static void main(String[] args) {

		BTIsNotBst tree = new BTIsNotBst();
		
		tree.root = new Node(4);
		
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3);        
       
        if (tree.isBST(tree.root)) 
           System.out.println("IS BST"); 
        else
           System.out.println("Not a BST"); 
	}

}
