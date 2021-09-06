
public class Edge implements Comparable<Edge>{

	public Vertex fromVertex;
	public Vertex toVertex;
	public int cost;
	
	public Edge(Vertex fromVertex, Vertex toVertex, int cost) {
		super();
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
		this.cost = cost;
	}

	@Override
	public int compareTo(Edge o) {
		return cost - o.cost;
	}

	public String toString() {
		return fromVertex + " -> " + toVertex + "(" + cost + ")";	
		}
	
	public boolean equals(Object p) {
		if(!(p instanceof Edge)) return false;
		Edge path = (Edge)p;
		return fromVertex.equals(path.fromVertex) &&
				toVertex.equals(path.toVertex) &&
				cost == path.cost;
	}
	
}
