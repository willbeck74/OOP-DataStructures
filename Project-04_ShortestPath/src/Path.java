import java.util.ArrayList;

public class Path implements Comparable<Path>{

	public Vertex vertex;
	public int totalCost;
	public String pathToThisVertex;
	public ArrayList<Edge> edges;
	
	public Path() {
		super();
//		this.vertex = null;
//		this.totalCost = 0;
//		this.pathToThisVertex = null;
	}
	
	public Path(Vertex vertex, int totalCost, String pathToThisVertex) {
		super();
		this.vertex = vertex;
		this.totalCost = totalCost;
		this.pathToThisVertex = pathToThisVertex;
	}

	@Override
	public int compareTo(Path o) {
		return totalCost - o.totalCost;
	}
	
	public Path clone() {
		Path ret = new Path();
		ret.edges = (ArrayList<Edge>) edges.clone();
		return ret;
	}
	
	public int getTotalCost() {
		int ret = 0;
		for(Edge e : edges) {
			ret += e.cost;
		}
		return ret;
	}
	
	public Vertex toVertex() {
		return edges.get(edges.size()-1).toVertex;
	}
	
	public Vertex fromVertex() {
		return edges.get(0).fromVertex;
	}

	public boolean equals(Object p) {
		if(!(p instanceof Path)) return false;
		Path path = (Path)p;
		return vertex.equals(path.vertex) &&
				pathToThisVertex.equals(path.pathToThisVertex) &&
				totalCost == path.totalCost;
	}
	
	public String toString() {
		return pathToThisVertex;
	}
	
}
