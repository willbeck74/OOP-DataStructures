
public class Tester {
	
	public static void main(String[] args) {
		Graph1 g1;
		
		g1 = new Graph1("trails.txt");
		System.out.println(g1.edgeCount());
		System.out.println(Dijkstra1.findShortestPath(g1, "LC", "ZC"));
	}

}
