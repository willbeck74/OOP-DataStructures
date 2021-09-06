import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree<T> {
	//********************************************* Done in class
	class Node implements Comparable<Node>{
		T data;
		Node left, right;

		//-----------------------------------------
		Node(T data) {
			this(data, null, null);
		}

		//-----------------------------------------
		Node(T data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}

		//-----------------------------------------
		@Override
		public String toString() {
			return data.toString();
		}

		//-----------------------------------------
		@Override
		public int compareTo(Node o) {
			return ((Comparable<T>)data).compareTo(o.data);
		}

		//-----------------------------------------
		int nodeCount() {
			return 1 + 
					(left == null ? 0 : left.nodeCount()) +
					(right == null ? 0 : right.nodeCount());
		}

		//-----------------------------------------
		boolean find(T key) {
			if(data.equals(key))	return true;
			if(left != null)		return(left.find(key));
			if(right != null)		return(right.find(key));
			return false;
		}

		//-----------------------------------------
		void add(Node n) {
			int v = this.compareTo(n);
			if(v < 0) {
				if(right == null)	right = n;
				else				right.add(n);
			} else if(v > 0) {
				if(left == null)	left = n;
				else				left.add(n);
			} else {
				n.right = right;
				right = n;
			}
		}

		//-----------------------------------------
		public String postOrderTraversal() {
			return  ( left == null ? "" : left.postOrderTraversal() ) + 
					( right == null ? "" : right.postOrderTraversal() ) +
					", " + data;
		}
		//----------------------------------------- Left subtree, Node, Right subtree
		public String inOrderTraversal() {
			return "";
		}
		
	}//===================================================================== End Node Class

	Node root;

	//********************************************* Done in class
	public BinaryTree(T data) {
		root = new Node(data);
	}

	//********************************************* TO DO
	public BinaryTree(T[] elements) {
		root = new BinaryTree.Node(elements);
	}

	//********************************************* Done in class
	public void add(T data) {
		root.add(new Node(data));
	}
	
	//********************************************* Done in class
	public int size() {
		return root.nodeCount();
	}

	//********************************************* Done in class
	public String breathFirstTraversal() {
		StringBuilder s = new StringBuilder();
		
		Queue<Node> q = new LinkedList<Node>();
		
		if(root != null) {
			q.add(root);
			while(!q.isEmpty()) {
				Node temp = q.remove();
				s.append(", " + temp.data);
				if(temp.left != null) q.add(temp.left);
				if(temp.right != null) q.add(temp.right);
			}
		}
		
		return "[" + s.toString().substring(2) + "]";
	}

	//********************************************* Done in class
	public String postOrderTraversal() {
		return "[" + root.postOrderTraversal().substring(2) + "]";
	}

	//********************************************* TO DO
	public String depthFirstTraversal() {
		StringBuilder s = new StringBuilder();
		Stack<Node> stack = new Stack<Node>();
		
		if(root != null) {
			stack.push(root);
			while(!stack.isEmpty()) {
				Node temp = stack.pop();
				s.append(", " + temp.data);
				if(temp.right != null) stack.push(temp.right);
				if(temp.left != null) stack.push(temp.left);
			}
		}
		
		return "[" + s.toString().substring(2) + "]";
	}

	//********************************************* TO DO
	public String inOrderTraversal() {
		StringBuilder ret = new StringBuilder();
		Stack<Node> s = new Stack<Node>();
		Node temp = root;
		while(temp != null) {
			s.push(temp);
			temp = temp.left;
		}
		while(!s.isEmpty()) {
			Node n = s.pop();
			ret.append(", " + n.data);
			n = n.right;
			while(n != null) {
				s.push(n);
				n = n.left;
			}
		}
		return "[" + ret.toString().substring(2) + "]";
	}

}

