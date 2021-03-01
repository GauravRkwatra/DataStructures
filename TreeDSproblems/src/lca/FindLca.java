package lca;

public class FindLca {

	Node root;
	
	Node findLCA(Node node, int n1, int n2) {
		// Base case
        if (node == null)
            return null;
        
        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (node.val == n1 || node.val == n2)
            return node;
 
        Node left_lca = findLCA(node.left, n1, n2);
        Node right_lca = findLCA(node.right, n1, n2);
        
        if (left_lca!=null && right_lca!=null)
            return node;
        
        return (left_lca != null) ? left_lca : right_lca;
	}
	
	public static void main(String[] args) {
		
		FindLca tree = new FindLca();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        
        System.out.println("LCA(4, 5) = " + tree.findLCA(tree.root, 4, 5).val);
        System.out.println("LCA(4, 6) = " + tree.findLCA(tree.root, 4, 6).val);
        System.out.println("LCA(3, 4) = " + tree.findLCA(tree.root, 3, 4).val);
        System.out.println("LCA(2, 4) = " + tree.findLCA(tree.root, 2, 4).val);

	}


	

}
