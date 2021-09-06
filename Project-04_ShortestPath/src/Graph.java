import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Graph implements GraphInterface{
	// ================================================== Properties
	private Set<Vertex> vertices;
	private ArrayList<Edge> edges;
	// ================================================== Constructors
	public Graph(String fileName) {
		vertices = new TreeSet<Vertex>();
		
		try(Scanner fin = new Scanner(new File(fileName))) {
			boolean isDirected = Boolean.parseBoolean(fin.nextLine());
			// Now read the single line of all possible vertex entries
			String[] parts = fin.nextLine().split("\t");
			for(String s : parts)
				vertices.add(new Vertex(s, 0));
			// Now read in all other lines. all paths with cost
			while(fin.hasNextLine()) {
				parts = fin.nextLine().split("\t");
				Vertex vertex = getVertex(parts[0]);
				Vertex vertex2 = getVertex(parts[1]);
				int cost = Integer.parseInt(parts[2]);
				if(!(vertex == null || vertex2 == null)) {
					addEdge(vertex, vertex2, cost);
					if(!isDirected) addEdge(vertex2, vertex, 0);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	// ================================================== Methods
	@Override
	public boolean addVertex(Vertex vertex) {
		if(vertex == null) return false;
		return vertices.add(vertex);
	}

	@Override
	public boolean removeVertex(Vertex vertex) { 
		if(vertex == null) return false;
		return vertices.remove(vertex);
	}

	@Override
	public Vertex getVertex(String name) { 
		for(Vertex v : vertices)
			if(v.name.equals(name)) return v;
		return null;
	}

	@Override
	public boolean removeEdge(Vertex vertex1, Vertex vertex2) {
		if(vertex1 == null || vertex2 == null) return false;
		return vertex1.adjacentVerticesCost.remove(vertex2.name) != null;
	}

	@Override
	public boolean hasEdge(Vertex vertex1, Vertex vertex2) {
		if(vertex1 == null || vertex2 == null) return false;
		return (vertex1.adjacentVerticesCost.containsKey(vertex2.name));
	}

	@Override
	public boolean hasVertex(Vertex vertex) { 
		if(vertex == null) return false;
		return vertices.contains(vertex);
	}

	@Override
	public boolean isEmpty() { 
		return vertices.isEmpty();
	}

	@Override
	public int vertexCount() { 
		return vertices.size();
	}

	@Override
	public int edgeCount() {
		int ret = 0;
		for(Vertex v : vertices)
			ret += v.;
		return ret;
	}
	@Override
	public Set getVertices() {
		Set<Vertex> ret = new TreeSet<Vertex>();
		for(Vertex v : vertices)
			ret.add(v);
		return ret;
	}
	@Override
	public boolean addEdge(Vertex fromVertex, Vertex toVertex, int cost) { 
		if(fromVertex == null || toVertex == null) return false;
		return edges.add(new Edge(fromVertex, toVertex, cost));
	}
	
	@Override
	public Edge getEdge(String fromVertexName, String toVertexName) { 
		for(Edge e : edges)
			if(e.toVertex.equals(toVertexName) &&
					e.fromVertex.equals(fromVertexName)) return e;
		return null;
	}
	
	@Override
	public ArrayList getEdges(Vertex fromVertex) { 
		ArrayList<Edge> ret = new ArrayList<Edge>();
		for(Edge e : edges)
			if(e.fromVertex.equals(fromVertex))
				ret.add(e);
			return ret;
	}
	 
	@Override
	public ArrayList getEdges() { 
		ArrayList<Edge> ret = new ArrayList<Edge>();
		for(Edge e : edges)
			ret.add(e);
		return ret;
	}

}
