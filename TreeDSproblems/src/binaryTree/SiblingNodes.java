package binaryTree;

public class SiblingNodes {

	Node root;
	
	int getLevel(Node node, Node chk, int lev) {
		
		if(node==null)
			return 0;
		
		int l = getLevel(node.left, chk, lev + 1);
		if(l!=0)
			return lev;
		
		return getLevel(node.right, chk, lev+1);
		
	}
	
	boolean isSibling(Node node, Node a, Node b) {
		
		if(node==null)
			return false;
		
		if(node.left ==a && node.right==b)
			return true;
		
		if(node.left ==b && node.right==a)
			return true;
		
		return isSibling(node.left, a, b) && isSibling(node.right, a, b);
	}
	
	boolean isCousin(Node node, Node a, Node b) {
		return (getLevel(node, a, 0)==getLevel(node, b, 0)
				&& !(isSibling(node, a, b)));		
	}
	
	public static void main(String[] args) {

		SiblingNodes tree = new SiblingNodes(); 
        tree.root = new Node(1); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(3); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(5); 
        tree.root.left.right.right = new Node(15); 
        tree.root.right.left = new Node(6); 
        tree.root.right.right = new Node(7); 
        tree.root.right.left.right = new Node(8); 
  
        Node Node1, Node2; 
        Node1 = tree.root.left.left; 
        Node2 = tree.root.right.right; 
        if (tree.isCousin(tree.root, Node1, Node2)) 
            System.out.println("Yes"); 
        else
            System.out.println("No"); 
	}

	
}
