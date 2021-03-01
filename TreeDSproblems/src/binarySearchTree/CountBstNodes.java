package binarySearchTree;

public class CountBstNodes {
	Node root;
	
	
	int getCount(Node root, int l, int h) {
	
		if(root==null)
			return 0;
		
		if(root.val >= l && root.val <=h)
			return 1 + getCount(root.left, l, h) + getCount(root.right, l, h);
		
		if(root.val > l)
			return getCount(root.left, l, h);
		return getCount(root.right, l, h);		
	}
	
	public static void main(String[] args) {
		CountBstNodes tree = new CountBstNodes(); 
        
        tree.root = new Node(10); 
        tree.root.left     = new Node(5); 
        tree.root.right     = new Node(50); 
        tree.root.left.left = new Node(1); 
        tree.root.right.left = new Node(40); 
        tree.root.right.right = new Node(100); 

        int l=5; 
        int h=45; 
        System.out.println("Count of nodes between [" + l + ", "
                          + h+ "] is " + tree.getCount(tree.root, 
                                                      l, h)); 
	}


	

}
