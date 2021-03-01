package binaryTree;

public class ShortDistBst {

	static int distanceFromRoot(Node root, int x)  {  
	    if (root.data == x)  
	        return 0;  
	    else if (root.data > x)  {
	    	int k = 1 + distanceFromRoot(root.left, x);  
	    	return k;
	    }
	    int j = 1 + distanceFromRoot(root.right, x);	        
	    return j;
	}
	
	public static void main(String[] args) {
		
		Node root = null;  
	    root = insert(root, 20);  
	    insert(root, 10);  
	    insert(root, 5);  
	    insert(root, 15);  
	    insert(root, 30);  
	    insert(root, 25);  
	    insert(root, 35);  
	    System.out.println(findDistWrapper(root, 25, 35)); 

	}
	
	static int findDistWrapper(Node root, int a, int b)  {  
	    int temp = 0; 
	    if (a > b) { 
		    temp = a; 
		    a = b; 
		    b = temp; 
	    }  
	    return distanceBetween2(root, a, b);  
	}  
	
	static int distanceBetween2(Node root, int a, int b)  {  
	    if (root == null)  
	        return 0;  
	  
	    // Both keys lie in left  
	    if (root.data > a && root.data > b)  
	        return distanceBetween2(root.left, a, b);  
	  
	    // Both keys lie in right  
	    if (root.data < a && root.data < b) // same path  
	        return distanceBetween2(root.right, a, b);  
	  
	    // Lie in opposite directions (Root is  
	    // LCA of two nodes)  
	    if (root.data >= a && root.data <= b)  {
	    	int x = distanceFromRoot(root, a);
	    	int y = distanceFromRoot(root, b);
	    	return x + y;
	    }	          
	    return 0; 
	}
	
	static Node insert(Node root, int key)  {  
	    if (root == null)  
	        root = new Node(key);  
	    else if (root.data > key)  
	        root.left = insert(root.left, key);  
	    else if (root.data < key)  
	        root.right = insert(root.right, key);  
	    return root;  
	}

}
