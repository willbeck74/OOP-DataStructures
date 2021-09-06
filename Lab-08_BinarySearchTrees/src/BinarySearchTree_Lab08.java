import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;



/*
 * 
 * Author: Will Beck
 * Date: October 14, 2020
 * Class: CSE 274, Michael Stahr
 * 
 */


/*
 	Lab-08: BinarySearchTree Implementation
 	
 	Rules:
 		1. Allow Tester to iterate through all nodes using the in-order traversal as the default.
 			This means, in Tester the following code should work for an instance of this class
 			called bst that is storing Student objects for the data:
 				
 				BinarySearchTree_Lab08<String> bst = new BinarySearchTree_Lab08<String>();
 				bst.add("Man");		bst.add("Soda");	bst.add("Flag");
 				bst.add("Home");	bst.add("Today");	bst.add("Jack");
 			
 				for(String s : bst) 
 					System.out.println(s);
*/


public class BinarySearchTree_Lab08<T extends Comparable<T>>{
//====================================================================================== Properties
	private Node root;
	private int nodeCount = 0;
	
	private Comparator<T> comp = new Comparator<T>() {
		public int compare(T o1, T o2) {
			return ( (Comparable)01 ).compareTo(o2);
		}
	};
	
	//====================================================================================== Constructors
	public BinarySearchTree_Lab08() {
		root = null;
	}
	
	// Constructor that takes an array of items and populates the tree
	public BinarySearchTree_Lab08(T[] items) {
		for(int i=0; i < items.length; i++) {
			root = add(root, items[i]);
		}
			
	}
	
	//====================================================================================== Methods
	public void add(T data) {	// Implement recursively and do NOT allow duplicates
		if(contains(data))
			return; 
		else {
			root = add(root, data);
			nodeCount++;
			return;
		}
	}
	private Node add(Node n, T data) {
		if(n == null) {
			n = new Node(data);
			return n;
		}
		else 
		if(data.compareTo(n.data) < 0) 		n.left = add(n.left, data);
		else 								n.right = add(n.right, data);
		return n;
		
	}

	// Returns the traversal of this tree as an array
	public ArrayList<T> preOrder_Traversal() {
	ArrayList<T> data = new ArrayList<T>();
	preOrder_Traversal(root, data);
	return data;
	}
	private void preOrder_Traversal(Node n, ArrayList<T> data) {
		if(n == null)	return;
		data.add(n.data);
		if(n.left != null)	preOrder_Traversal(n.left, data);
		if(n.right != null)	preOrder_Traversal(n.right, data);
	}

	public ArrayList<T> inOrder_Traversal() {
	ArrayList<T> data = new ArrayList<T>();
	inOrder_Traversal(root, data);
	return data;
	}
	private void inOrder_Traversal(Node n, ArrayList<T> data) {
		if(n == null) return;
		if(n.left != null)		inOrder_Traversal(n.left, data);
		data.add(n.data);
		if(n.right != null)		inOrder_Traversal(n.right, data);
	}

	public ArrayList<T> postOrder_Traversal() {
	ArrayList<T> data = new ArrayList<T>();
	postOrder_Traversal(root, data);
	return data;
	}
	private void postOrder_Traversal(Node n, ArrayList<T> data) {
		if(n == null)	return;
		if(n.left != null)		postOrder_Traversal(n.left, data);
		if(n.right != null)		postOrder_Traversal(n.right, data);
		data.add(n.data);
	}

	public ArrayList<T> breathFirst_Traversal() {
		
		ArrayList<T> s = new ArrayList<T>();
		Queue<Node> q = new LinkedList<Node>();
		
		if(root != null) {
			q.add(root);
			while(!q.isEmpty()) {
				Node temp = q.remove();
				s.add(temp.data);
				if(temp.left != null) q.add(temp.left);
				if(temp.right != null) q.add(temp.right);
			}
		}
		
		return s;
	}

	// Since this is a binary SEARCH tree, you should write
	// an efficient solution to this that takes advantage of the order
	// of the nodes in a BST.  Your algorithm should be, on average,
	// O(h) where h is the height of the BST.
	public boolean contains(T data) { return recContains(data, root); }
	private boolean recContains(T data, Node n) {
		if(n == null) return false;
		int d = data.compareTo(n.data);
		if(d == 0) return true;
		return recContains(data, (d < 0 ? n.left : n.right));
	}

	// returns the smallest value in the tree
	// or throws an IllegalStateException() if the
	// tree is empty.  Write the recursive version 
	public T min() { return min(root); }		// this method is done for you.		
	private T min(Node n) {	// Write this method.
		if(isEmpty()) {return null; }
		else {
			Node node = n;
			while(node.left != null)
				node = node.left;
			return node.data;
		}
	}
	
	// returns the largest value in the tree
	// or throws an IllegalStateException() if the
	// tree is empty.  Write the recursive version
	public T max() { return max(root); }		// this method is done for you.
	private T max(Node n) {	// Write this method. 
		if(isEmpty()) {return null; }
		else {
			Node node = n;
			while(node.right != null)
				node = node.right;
			return node.data;
		}
	}
	
	// Returns whether the tree is empty
	public boolean isEmpty() {
		return root == null;
	}
	
	// returns the height of this BST. If a BST is empty, then
	// consider its height to be -1.
	public int getHeight() {
		return getHeight(root);
	}
	private int getHeight(Node n) {
		if(n == null)
			return -1;
		return Math.max(getHeight(n.left), getHeight(n.right)) +1;
		
	}

	// returns the largest value of all the leaves
	// If the tree is empty, throw an IllegalStateException()
	// Note, this is different than max as this is the max
	// of all leaf nodes
	public T maxLeaf() {
		Node n = maxLeaf(root);
		return n.data;
	}

	private Node maxLeaf(Node n) {
		if(n == null) throw new IllegalStateException();
		while(n.right != null)
			n = n.right;
		return n;
	}

	// counts the number of nodes in this BST
	public int nodeCount() {
		return nodeCount(root);
	}
	private int nodeCount(Node n) {
		if(n == null)	return 0;
		int leftCount = nodeCount(n.left);
		int rightCount = nodeCount(n.right);
		return leftCount + rightCount + 1;
	}

	// returns the "level" of the value in a tree.
	// the root is considered level 0
	// the children of the root are level 1
	// the children of the children of the root are level 2
	// and so on.  If a value does not appear in the tree, return -1
	//              15
	//             /  \
	//            10  28
	//              \   \
	//              12  40
	//                 /
	//                30
	// In the tree above:
	// getLevel(15) would return 0
	// getLevel(10) would return 1
	// getLevel(30) would return 3
	// getLevel(8) would return -1
	public int getLevel(T n) {
		if(contains(n))
			return getLevel(root, n, 0);
		return -1;
	}

	
	private int getLevel(Node n, T data, int i) {
		if(n == null)
			return 0;
		if(n.data == data)
			return i;
		int level = getLevel(n.left, data, i+1);
		if(level != 0)
			return level;
		level = getLevel(n.right, data, i+1);
			return level;
	}

	// *********************************************************
	// EXTRA CREDIT: 5pts
	// *********************************************************
	// A tree is height-balanced if at each node, the heights
	// of the node's two subtrees differs by no more than 1.
	//  Special note about null subtrees:
	//            10
	//              \
	//               20
	// Notice in this example that 10's left subtree is null,
	// and its right subtree has height 0. We would consider this
	// to be a balanced tree. If the tree is empty, return true;
	public boolean isBalanced() {
		return false;
	}
	
	public Iterator<T> iterator() {
		return getIterator(enuTraversalType.IN_ORDER);
	}
	
	public Iterator<T> getIterator(enuTraversalType orderType) {
		final LinkedList<T> ret = new LinkedList<T>();
		
		switch(orderType) {
		case LEVEL_ORDER: 	breathFirst_Traversal(); break;
		case IN_ORDER:		inOrder_Traversal(); break;
		case PRE_ORDER: 	preOrder_Traversal();break;
		case POST_ORDER: 	postOrder_Traversal(); break;
		}
		return new Iterator<T>() {

			@Override
			public boolean hasNext() { return !ret.isEmpty(); }

			@Override
			public T next() {
				if(!hasNext()) throw new IndexOutOfBoundsException();
				return ret.remove();
			}
			
		};
	}
	
	//====================================================================================== Inner Node Class
	private class Node {
		private T data;
		private Node left, right;
		
		private Node(T data) {
			this.data = data;
			left = right = null;
		}
	}
}

