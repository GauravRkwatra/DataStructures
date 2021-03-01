package binaryTree;

public class KDistance_Node {
	Node root;
	
	void printKDistanceNodes(Node n, int k) {
	
		if(n==null)
			return;
		
		if(k==0)
			System.out.println(n.data);
		else {
			printKDistanceNodes(n.left, k-1);
			printKDistanceNodes(n.right, k-1);
		}
	}
	
	int printkdistanceNode(Node n, Node t, int k) {
		System.out.println("Node "+printNode(n));
		if(t==null || n ==null || k<0)
			return -1;
		
		if(n==t) {
			printKDistanceNodes(n, k);
			return 0;
		}
		
		int dl = printkdistanceNode(n.left, t, k);
		System.out.println("DL-Node-Left "+(printNode(n))+" || Distance From Root : "+dl);
		if(dl!=-1) {
			// If root(parent node of target node), print that node 
			if(dl+1==k) {
				System.out.println("Found Root(Parent Node) at distance K from target");
				System.out.print(n.data); 
                System.out.println(""); 
			} else
				printKDistanceNodes(n.right, k-dl-2);
			return 1 + dl;
		}
		
		int dr = printkdistanceNode(n.right, t, k);
		System.out.println("DL-Node-Right "+(printNode(n))+" || Distance From Root : "+dr);
		if(dr!=-1) {
			if(dr+1==k) {
				System.out.println("Found Root at distance K from target");
				System.out.print(n.data); 
                System.out.println(""); 
			} else 
				printKDistanceNodes(n.left, k-dr-2);
			return 1 + dr;			
		}		
		return -1;
	}
	
	
	public static void main(String[] args) {
		KDistance_Node tree=  new KDistance_Node();
		
		tree.root = new Node(20); 
		
        tree.root.left = new Node(8); 
        tree.root.right = new Node(22); 
        
        tree.root.left.left = new Node(4); 
        tree.root.left.right = new Node(12); 
        
        tree.root.left.right.left = new Node(10); 
        tree.root.left.right.right = new Node(14); 
        
        // 4 left and right
        tree.root.left.left.right = new Node(6);
        
        // 14 left and right
        tree.root.left.right.right.right = new Node(13);
        tree.root.left.right.right.left = new Node(15);
        
        // target = 8
        Node target = tree.root.left.right; 
        tree.printkdistanceNode(tree.root, target, 2); 

	}
	
	Integer printNode(Node n) {
		
		if(n!=null)
			return n.data;
		else
			return null;
	}

}
