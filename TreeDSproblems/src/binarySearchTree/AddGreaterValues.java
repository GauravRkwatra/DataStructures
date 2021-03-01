package binarySearchTree;

public class AddGreaterValues {

	Node root;
	int count = 0;
	void addGreaterVal(Node node) {
		
		if(node==null)
			return;
		
		addGreaterVal(node.right);
		
		count = count + node.val;
		node.val = count;
		
		addGreaterVal(node.left);
	}
	
	public static void main(String[] args) {
		AddGreaterValues t = new AddGreaterValues();
		
		
		t.root = new Node(50);
		
		// 50 left right
		t.root.left = new Node(30);
		t.root.right = new Node(70);
		
		// 30 left right
		t.root.left.left = new Node(20);
		t.root.left.right = new Node(40);
		
		// 70 left right
		t.root.right.left = new Node(60);
		t.root.right.right = new Node(80);
		
		t.addGreaterVal(t.root);
	}

}
