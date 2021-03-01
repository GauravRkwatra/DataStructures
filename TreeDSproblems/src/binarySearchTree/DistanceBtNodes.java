package binarySearchTree;

public class DistanceBtNodes {

	 static int distanceBetween2(Node root, int a, int b)  { 
	 
		 if(root==null)
			 return 0;
		 
		 if(root.val>a && root.val>b) {
			return distanceBetween2(root.right, a, b);
		 }
		 
		 if(root.val<a && root.val<b) {
			 return distanceBetween2(root.left, a, b);
		 }
		 
		 if(root.val>a && root.val<b) {
			 int x = distanceFromRoot(root, a);
			 int y = distanceFromRoot(root, b);
			 return x + y;
		 }
		 return 0;		 
	 }
	 
	 static int distanceFromRoot(Node root, int x)  {  
	     if (root.val == x)  
	         return 0;  
	     else if (root.val > x)  
	         return 1 + distanceFromRoot(root.left, x);  
	     return 1 + distanceFromRoot(root.right, x);  
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
		 
		 System.out.println(disWrapper(root, 5, 35)); 

	}
	
	static int disWrapper(Node root, int a, int b) {
		
		if(a > b) {
			int temp = a;
			b = a;
			a = temp;
		}
		return distanceBetween2(root, a, b);
	}
	
	// Standard BST insert function  
	static Node insert(Node root, int key)  {  
	    if (root == null)  
	        root = new Node(key);  
	    else if (root.val > key)  
	        root.left = insert(root.left, key);  
	    else if (root.val < key)  
	        root.right = insert(root.right, key);  
	    return root;  
	}  

}
