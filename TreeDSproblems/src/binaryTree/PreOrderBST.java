package binaryTree;

import java.util.Stack;

public class PreOrderBST {
	
	boolean canRepresentBST(int[] pre, int n) {
		
		Stack<Integer> s = new Stack<Integer>(); 
		
		int root = Integer.MIN_VALUE; 
		
		for (int i = 0; i < n; i++) {
			
			if(pre[i] < root) { 
                return false; 
            }
			
			while (!s.empty() && s.peek() < pre[i]) { 
				System.out.println(s.peek()); 
	            root = s.pop();            
	        }
			s.push(pre[i]); 
		}
		return true;
	}

	public static void main(String[] args) {

		PreOrderBST bst = new PreOrderBST();
		int[] pre1 = new int[]{40, 30, 35, 80, 100}; 
        int n = pre1.length; 
        if (bst.canRepresentBST(pre1, n) == true) { 
            System.out.println("true"); 
        } else { 
            System.out.println("false"); 
        } 
        int[] pre2 = new int[]{40, 30, 35, 20, 80, 100}; 
        int n1 = pre2.length; 
        if (bst.canRepresentBST(pre2, n) == true) { 
            System.out.println("true"); 
        } else { 
            System.out.println("false"); 
        } 
	}
}
