package binarySearchTree;

public class IncreasingBST {
	Node root;
	static Node prev = new Node(0);
	static Node head= prev;
	void increasingBST(Node root) {
	
		if(root==null)
            return;
		System.out.println(root);
        increasingBST(root.left); 
        
        root.left = null;
        prev.right = root;
        prev = root;
        
        increasingBST(root.right);   
	}
	
	public static void main(String[] args) {
		IncreasingBST in = new IncreasingBST();
		
		in.root = new Node(5);
		
		in.root.left = new Node(3);
		in.root.right = new Node(6);

		// 3 Left and Right
		in.root.left.left = new Node(2);
		in.root.left.right = new Node(4);
		
		// 6 Right
		in.root.right.right = new Node(8);
				
		// 2 Left and Right
		in.root.left.left.left  = new Node(1);
		
		// 8 Left and Right
		in.root.right.right.left = new Node(7);
		in.root.right.right.right = new Node(9);
		
		in.increasingBST(in.root);
	//	Node i = in.increasingBST(in.root);
		//System.out.println(i);
		
		preOrderTraverse(head.right);
	}

	static void preOrderTraverse(Node root) {
		if(root==null)
			return;
		
		System.out.print(" "+root.val);
		preOrderTraverse(root.left);
		
		preOrderTraverse(root.right);
	}
}
