
public class Tester {

	public static void main(String[] args) {
		BinaryTree<Integer> root = new BinaryTree<Integer>(50);
		root.add(75);
		root.add(60);
		root.add(80);
		root.add(77);
		root.add(78);
		root.add(30);
		root.add(20);
		root.add(35);
		root.add(37);
		root.add(33);
		root.add(75);
		System.out.println("Breath First: " + root.breathFirstTraversal());
		System.out.println("Post Order  : " + root.postOrderTraversal());
		System.out.println("Depth First : " + root.depthFirstTraversal());
		System.out.println("In-Order    : " + root.inOrderTraversal());
	}
}
