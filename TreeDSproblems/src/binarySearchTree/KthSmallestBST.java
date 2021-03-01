package binarySearchTree;

public class KthSmallestBST {
	
	static int count = 0; 
	static int rCount = 0; 
    
	public static Node kthSmallest(Node root, int k) {
		System.out.println("------------------------------------------------");
		
        if (root == null)
            return null;
        
        System.out.println("Node "+root.val+" || Count "+count);
        
        System.out.println("Left "+root.left);
        
        Node left = kthSmallest(root.left, k);

        if (left != null)
            return left;

        count++;
        if (count == k)
            return root;

        System.out.println("Right "+root.right);
        return kthSmallest(root.right, k);
    }	
	
	
	
	public static Node KthLargest(Node node, int k) {
		
		if(node==null)
			return null;
		
		Node right = KthLargest(node.right, k);
		
		if(right!=null)
			return right;
		
		++rCount;
		if(rCount==k)
			return node;
		
		return KthLargest(node.left, k);
		
	}
	
	public static void main(String[] args) {
		
		Node root = null;
        int keys[] = { 20, 8, 22, 4, 12, 10, 14 };
      
        for (int x : keys)
            root = insert(root, x);
         
        int k = 3;
        Node n = kthSmallest(root, k);
        System.out.println("N: "+n.val);
        System.out.println("Largest: "+KthLargest(root, k));
	}
	
	 public static Node insert(Node root, int x) {
		 if (root == null)
			 return new Node(x);
	     if (x < root.val)
	         root.left = insert(root.left, x);
	     else if (x > root.val)
	         root.right = insert(root.right, x);
	     return root;
	 }
}
