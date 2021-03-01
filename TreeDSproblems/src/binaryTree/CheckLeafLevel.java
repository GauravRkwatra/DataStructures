package binaryTree;

public class CheckLeafLevel {
	Node root;
	static Leaf mylevel = new Leaf();
	
	static class Leaf {
		int leafLevel = 0;
		@Override
		public String toString() {
			return "Leaf [leafLevel=" + leafLevel + "]";
		}
	}
	
	boolean checkUtil(Node node, int level, Leaf ll) {
		System.out.println("-------------------------------------------");
		if(node==null)
			return true;
		
		System.out.println("Node "+node.data);
		System.out.println("Level: "+level+" LL "+ll);
		
		if (node.left ==null && node.right==null) {
		
			// If leaf found first time just assign the level
			if(ll.leafLevel == 0) {	
				System.out.println("Level Assign "+level);
				ll.leafLevel = level;
				//return true;
			} else {
				return (level == ll.leafLevel);
			}
		}
		return checkUtil(node.left, level+1, ll) && checkUtil(node.right, level+1, ll);		
	}
	
	boolean check(Node node) {
        int level = 0;
        return checkUtil(node, level, mylevel);
    }
	
	public static void main(String[] args) {
		
		CheckLeafLevel tree = new CheckLeafLevel();
		tree.root = new Node(12);
        
		tree.root.left = new Node(5);
		//tree.root.right = new Node(7);
		
        tree.root.left.left = new Node(3);
        tree.root.left.right = new Node(9);
        
        tree.root.left.left.left = new Node(1);
        tree.root.left.right.left = new Node(2);
        
        if (tree.checkUtil(tree.root, 0, mylevel))
            System.out.println("Leaves are at same level");
        else
            System.out.println("Leaves are not at same level");
	}

}
