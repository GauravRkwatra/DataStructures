package binaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightView {

	Node root;
	int maxLevelSoFar = -1;

	class QueueNode {
	
		Node node;
		int level;
		
		QueueNode(Node node, int level) {
			this.node = node;
			this.level = level;
		}		
	}
	
	private List<Integer> printRightViewLevelOrder (int maxLevelSoFar) {
	
		List<Integer> list = new LinkedList<>();
        
        if (root==null)
            return list;
        
        Queue<QueueNode> q = new LinkedList<>();
        q.add(new QueueNode(root, 0));
        
        while(!q.isEmpty()) {
        	
        	QueueNode temp = q.poll();
        	
        	if(temp.level > maxLevelSoFar) {
        		list.add(temp.node.data);
        		maxLevelSoFar = temp.level;
        	}
        	
        	if(temp.node.right!=null) {
        		q.add(new QueueNode(temp.node.right, temp.level + 1));
        	}
        	
        	if(temp.node.left!=null) {
        		q.add(new QueueNode(temp.node.left, temp.level + 1));
        	}
        }
        return list;
	}
	
	List<Integer> list  = new LinkedList<>();
	
	private List<Integer> printRightView(Node root, int currentLevel) {

		if (root == null)
			return list;
		
		if (currentLevel > maxLevelSoFar) {
			list.add(root.data);
			maxLevelSoFar = currentLevel;
		}
		
		printRightView(root.right, currentLevel + 1);	
		printRightView(root.left, currentLevel + 1);
		
		return list;
	}

	public static void main(String[] args) {

		RightView tree = new RightView();
		
//		tree.root = new Node(1); 
//        
//		tree.root.left = new Node(2); 
//        tree.root.right = new Node(3); 
//        
//        tree.root.left.left = new Node(4); 
//        tree.root.left.right = new Node(5); 
//        
//        tree.root.right.left = new Node(6); 
//        tree.root.right.right = new Node(7); 
//        
//        tree.root.right.right.right = new Node(8); 
        
        tree.root = new Node(12);
		
		tree.root.left = new Node(10);
		tree.root.right = new Node(30);
		
		tree.root.left.left = new Node(15);
		
		tree.root.right.left = new Node(25);
		tree.root.right.right = new Node(40);
        
        List<Integer> l =tree.printRightView(tree.root, 0);
        System.out.println("Recursion: "+l);
		l = tree.printRightViewLevelOrder(-1);
		System.out.println();
		System.out.println("Level Order: "+l);
	}

}
