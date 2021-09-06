import java.io.File; 
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class Graph1 implements GraphInterface {

	//====================================================================================== Properties
	private Set<Vertex> vertices;
	private ArrayList<Edge> edges = new ArrayList<Edge>();

	//====================================================================================== Constructors
	public Graph1(String fileName) {
		vertices = new TreeSet<Vertex>();	
		try(Scanner fin = new Scanner(new File(fileName))){
			boolean isDirected = Boolean.parseBoolean(fin.nextLine());

			// Now read the single line of all possible vertex entries
			String[] parts = fin.nextLine().split("\t");
			for(String s : parts)
				vertices.add(new Vertex(s));

			// Now read in all other lines... all paths with cost
			while(fin.hasNextLine()) {
				parts = fin.nextLine().split("\t");
				Vertex vertex = getVertex(parts[0]);
				Vertex vertex2 = getVertex(parts[1]);
				int cost = Integer.parseInt(parts[2]);
				if(!(vertex == null || vertex2 == null || cost == 0)) {
					addEdge(vertex, vertex2, cost);
					if(!isDirected) addEdge(vertex2, vertex, cost);
				}
			}	
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	//====================================================================================== Methods
	//============================== Vertex Methods
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

	public boolean addEdge(Vertex vertex1, Vertex vertex2, int cost) {
		if(vertex1 == null || vertex2 == null || cost == 0) return false;
		return edges.add(new Edge(vertex1, vertex2, cost));
	}

	@Override
	public boolean hasVertex(Vertex vertex) {
		if(vertex == null) return false;
		return vertices.contains(vertex);
	}

	public Set<Vertex> getVertices(){
		Set<Vertex> ret = new TreeSet<Vertex>();
		for(Vertex v : vertices)
			ret.add(v);
		return ret;
	}

	@Override
	public int vertexCount() {
		return vertices.size();
	}

	//============================== Edge Methods
	@Override
	public boolean removeEdge(Vertex vertex1, Vertex vertex2) {
		if(vertex1 == null || vertex2 == null) return false;
		return edges.remove(this.getEdge(vertex1.name, vertex2.name)); 
	}

	@Override
	public boolean hasEdge(Vertex vertex1, Vertex vertex2) {
		if(vertex1 == null || vertex2 == null) return false;
		Edge temp = this.getEdge(vertex1.name, vertex2.name); 
		if (temp != null)
			return true;
		else
			return false;
	}

	@Override
	public int edgeCount() {
		return edges.size(); 
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

	@Override
	public boolean isEmpty() {
		return vertices.isEmpty();
	}
	
}
