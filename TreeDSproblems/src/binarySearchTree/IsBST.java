package binarySearchTree;

public class IsBST {
	
	static class BSTPair {
		boolean isBST;
		int min;
		int max;
		int size;
		Node root;
		@Override
		public String toString() {
			return "BSTPair [isBST=" + isBST + ", min=" + min + ", max=" + max + ", size=" + size + "]";
		}
	}
	
	Node root;
	Node prev; 
	
	boolean isBST(Node node) {
	
		if(node!=null) {
			
			if (!isBST(node.left)) {
				return false;
			}
			
			if(prev!=null && node.val <= prev.val)
				return false;
			prev = node;
			
			return isBST(node.right);
		}
		return true;	
	}
	
	public static void main(String[] args) {
		IsBST tree = new IsBST(); 
        tree.root = new Node(4); 
        tree.root.left = new Node(2); 
        tree.root.right = new Node(5); 
        tree.root.left.left = new Node(1); 
        tree.root.left.right = new Node(3); 
  
//        if (tree.isBST(tree.root)) 
//            System.out.println("IS BST"); 
//        else
//            System.out.println("Not a BST"); 
        
        System.out.println("IS-BSTT:  "+isBSTT(tree.root).isBST);
	}
	
	static BSTPair isBSTT(Node node) {
		if(node==null) {
			BSTPair bp = new BSTPair();
		    bp.min = Integer.MAX_VALUE;
		    bp.max = Integer.MIN_VALUE;
		    bp.isBST = true;
		    return bp;
		}
		
		BSTPair lp = isBSTT(node.left);
		BSTPair rp = isBSTT(node.right);
		
		BSTPair mp = new BSTPair();
		mp.isBST = lp.isBST && rp.isBST &&
					(node.val > lp.max && node.val <rp.min);
		
		mp.min = Math.min(node.val, Math.min(lp.min, rp.min));
		mp.max = Math.max(node.val, Math.max(lp.max, rp.max));  
		System.out.println("MP: "+mp);
		return mp;
	}
}

