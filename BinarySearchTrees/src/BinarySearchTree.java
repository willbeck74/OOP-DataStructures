import java.util.Comparator; 
import java.util.Iterator;
import java.util.LinkedList;

public class BinarySearchTree<E> implements BSTInterface<E> {

	// ==========================================================
	private class Node {
		E data;
		Node left, right;
		
		public Node(E data) {
			this(data, null, null);
		}
		
		public Node(E data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	
	// ==========================================================
	private int size = 0;
	private Node root = null;
	private Comparator<E> comp = new Comparator<E>() {
		public int compare(E o1, E o2) {
			return ( (Comparable)o1 ).compareTo(o2);
		}
	};
	
	
	public BinarySearchTree() {
		super();
		clear();
	}
	
	public BinarySearchTree(Comparator<E> comp) {
		this.comp = comp;
	}
	
	@Override
	public boolean isFull() {
		return false;
	}

	@Override
	public boolean add(E e) {
		if(e == null) return false;
		root = add(root, e);
		return true;
	}

	private Node add(Node n, E data) {
		if(n == null) return new Node(data);
		if( comp.compare(n.data, data) < 0 )	n.right = add(n.right, data);
		else									n.left = add(n.left, data);
		return n;
	}

	@Override
	public void clear() {
		 size = 0;
		 root = null;
	}

	@Override
	public boolean contains(E e) {
		return contains(e, root);
	}

	private boolean contains(E data, Node n) {
		if(n == null) return false;
		int d = (comp.compare(data, n.data));
		if(d == 0) return true;
		return contains(data, d < 0 ? n.left : n.right);
		
	}
	
	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public boolean remove(E e) {
		return false;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public Iterator<E> iterator() {
		return getIterator(enuTraversalType.IN_ORDER);
	}

	@Override
	public E min() {
		if(isEmpty()) return null;
		Node temp = root;
		while(temp.left !=null)
			temp = temp.left;
		return temp.data;
	}

	@Override
	public E max() {
		if(isEmpty()) return null;
		Node temp = root;
		while(temp.right !=null)
			temp = temp.right;
		return temp.data;
	}

	@Override
	public Iterator<E> getIterator(enuTraversalType orderType) {
		final LinkedList<E> ret = new LinkedList<E>();
		
		switch(orderType) {
		case LEVEL_ORDER: 	levelOrder(root, ret); break;
		case IN_ORDER:		inOrder(root, ret);break;
		case PRE_ORDER: 	preOrder(root, ret);break;
		case POST_ORDER: 	postOrder(root, ret);break;
		}
		return new Iterator<E>() {

			@Override
			public boolean hasNext() { return !ret.isEmpty(); }

			@Override
			public E next() {
				if(!hasNext()) throw new IndexOutOfBoundsException();
				return ret.remove();
			}
			
		};
	}

	private void levelOrder(Node node, LinkedList<E> ret) {
		if(node == null) return;
		
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(node);
		
		while(!q.isEmpty()) {
			Node temp = q.remove();
			ret.add(temp.data);
			if(temp.left != null) q.add(temp.left);
			if(temp.right != null) q.add(temp.right);
		}
	}

	private void inOrder(Node node, LinkedList<E> ret) {
		if(node == null) return;
		if(node.left != null) inOrder(node.left, ret);
		ret.add(node.data);
		if(node.right != null) inOrder(node.right, ret);
	}

	private void preOrder(Node node, LinkedList<E> ret) {
		if(node == null) return;
		ret.add(node.data);
		if(node.left != null) preOrder(node.left, ret);
		if(node.right != null) preOrder(node.right, ret);
	}

	private void postOrder(Node node, LinkedList<E> ret) {
		if(node == null) return;
		if(node.left != null) postOrder(node.left, ret);
		if(node.right != null) postOrder(node.right, ret);
		ret.add(node.data);
	}

}
