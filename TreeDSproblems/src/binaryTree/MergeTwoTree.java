package binaryTree;

public class MergeTwoTree {
	Node root;
	Node mergeTwoTree(Node root1, Node root2) {

		if(root1==null && root2==null)
            return null;
		
		if(root1==null && root2!=null)
            return root2;

		if(root1!=null && root2==null)
            return root1;
        
        Node curr = new Node(root1.data + root2.data);
        curr.left = mergeTwoTree(root1.left, root2.left);
        curr.right = mergeTwoTree(root1.right, root2.right); 
        
		return curr;		
	}
	
	public static void main(String[] args) {
		MergeTwoTree tree= new MergeTwoTree();
		
		tree.root = new Node(1);
		
		tree.root.left = new Node(3);
		tree.root.right = new Node(2);

		tree.root.left.left = new Node(5);
		
		MergeTwoTree tree2= new MergeTwoTree();
		
		tree2.root = new Node(2);
		
		tree2.root.left = new Node(1);
		tree2.root.right = new Node(3);
		
		tree2.root.left.right = new Node(4);
		
		tree2.root.right.right = new Node(7);
		
		Node root3 = tree.mergeTwoTree(tree.root, tree2.root);
		tree.preOrderTraverse(root3);
	}
	
	
	void preOrderTraverse(Node root) {
		if(root==null)
			return;
		
		System.out.print(" "+root.data);
		preOrderTraverse(root.left);		
		preOrderTraverse(root.right);	
	}

}
