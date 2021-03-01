package binaryTree;

public class LCSBST {

	Node root;
	
	Node lca(Node root, int n1, int n2) {
		System.out.println("N1: "+n1+" -N2: "+n2);
		while(root!=null) {
			
			if(root.data>n1 && root.data >n2)
				root = root.left;
			else if (root.data < n1 && root.data < n2)
				root = root.right;
			else {
				System.out.println("Data: "+root.data);
				break;
			}
		}
		return root;
	}
	
	public static void main(String[] args) {

		LCSBST tree = new LCSBST(); 
        tree.root = new Node(20); 
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
  
        int n1 = 10, n2 = 14; 
        Node t = tree.lca(tree.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is: " + t.data); 
        System.out.println("----------------------------------------------------------------");
        n1 = 14; 
        n2 = 8; 
        t = tree.lca(tree.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is: " + t.data); 
        System.out.println("----------------------------------------------------------------");
        n1 = 10; 
        n2 = 22; 
        t = tree.lca(tree.root, n1, n2); 
        System.out.println("LCA of " + n1 + " and " + n2 + " is: " + t.data); 
	}
}
