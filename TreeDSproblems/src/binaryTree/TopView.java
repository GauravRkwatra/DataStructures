package binaryTree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;
import java.util.TreeMap;

public class TopView {
	Node root;

	private void solutionRecursive() {
		
		class qObj {
			Node node;
			int hd;
			
			qObj(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}

			@Override
			public String toString() {
				return "qObj [node=" + node + ", hd=" + hd + "]";
			}
		}
		
		Queue<qObj> q = new LinkedList<>();
		q.add(new qObj(root, 0));
		
		Map<Integer, Node> tMap = new TreeMap<Integer, Node>();
		
		while (!q.isEmpty()) {
			System.out.println("QUEUE: "+q);
			qObj temp = q.poll();
			
			if(!tMap.containsKey(temp.hd)) {
				tMap.put(temp.hd, temp.node);
			}

			if(temp.node.left!=null) {
				q.add(new qObj(temp.node.left, temp.hd-1));
			}
			
			if(temp.node.right!=null) {
				q.add(new qObj(temp.node.right, temp.hd+1));
			}
		}
		for (Entry<Integer, Node> entry : tMap.entrySet()) {
			System.out.print(entry.getValue().data+" ");             
		}
		
	}
	
	public void solution() {
		
		class qObj {
			Node node;
			int hd;
			
			qObj(Node node, int hd) {
				this.node = node;
				this.hd = hd;
			}

			@Override
			public String toString() {
				return "qObj [node=" + node + ", hd=" + hd + "]";
			}
		}
		
		Queue<qObj> q = new LinkedList<>();
		q.add(new qObj(root, 0));
		
		Map<Integer, Node> tMap = new TreeMap<Integer, Node>();
		
		while (!q.isEmpty()) {
			System.out.println("QUEUE: "+q);
			qObj temp = q.poll();
			
			if(!tMap.containsKey(temp.hd)) {
				tMap.put(temp.hd, temp.node);
			}

			if(temp.node.left!=null) {
				q.add(new qObj(temp.node.left, temp.hd-1));
			}
			
			if(temp.node.right!=null) {
				q.add(new qObj(temp.node.right, temp.hd+1));
			}
		}
		for (Entry<Integer, Node> entry : tMap.entrySet()) {
			System.out.print(entry.getValue().data+" ");             
		}
		
	}
	public static void main(String[] args) {

		TopView tV = new TopView();
		tV.root = new Node(3);
		tV.root.left = new Node(9);
		tV.root.right = new Node(20);
		
		tV.root.right.left = new Node(15);
		tV.root.right.right = new Node(7);
		
		tV.solution();
		tV.solutionRecursive();
	}
	
}
