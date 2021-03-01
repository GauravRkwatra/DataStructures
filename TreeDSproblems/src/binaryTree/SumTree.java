package binaryTree;

public class SumTree {
	Node root;
	int ls =0, rs =0;
	int isLeaf(Node node) {
		if(node==null)
			return 1;
		
		if(node.left==null && node.right==null)
			return 1;
		return 0;
	}
	
	int isSumTree(Node node) {
		System.out.println("Node: "+node);
		if(node==null || isLeaf(node)==1)
			return 1;
		
		if(isSumTree(node.left)!=0 && isSumTree(node.right)!=0) {
			
			if(node.left==null)
				ls = 0;
			else if(isLeaf(node.left)!=0)
				ls=node.left.data;
			else {
				ls = 2 * node.left.data;
			}
			
			if(node.right==null)
				rs = 0;
			else if(isLeaf(node.right)!=0)
				rs = node.right.data;
			else
				rs = 2 * node.right.data;
			
			if(node.data == (ls + rs)) {
				System.out.println("Node.DATA: "+node.data+" == LS "+ls+" RS: "+rs);
				return 1;
			} else {
				return 0;
			}
		}
		return 0;
	}
	
	public static void main(String[] args) {
		SumTree tree = new SumTree();
        tree.root = new Node(26);
        tree.root.left = new Node(10);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(6);
        tree.root.right.right = new Node(3);
  
        if (tree.isSumTree(tree.root) >= 0)
            System.out.println("The given tree is a SumTree");
        else
            System.out.println("The given tree is not a SumTree");

	}

	

}
