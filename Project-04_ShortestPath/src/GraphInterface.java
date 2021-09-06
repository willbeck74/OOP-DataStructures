import java.util.ArrayList;
import java.util.Set;

public interface GraphInterface {
	public int 			vertexCount();
	public boolean 		addVertex(Vertex vertex);
	public boolean 		removeVertex(Vertex vertex);
	public boolean 		hasVertex(Vertex vertex);
	public Vertex 		getVertex( String name );
	public Set			getVertices();			// return all vertices
	
	public int 			edgeCount();
	public boolean 		addEdge(Vertex fromVertex, Vertex toVertex, int cost);
	public boolean 		removeEdge(Vertex fromVertex, Vertex toVertex);
	public Edge			getEdge(String fromVertexName, String toVertexName);
	public boolean 		hasEdge(Vertex fromVertex, Vertex toVertex);
	public ArrayList	getEdges(Vertex fromVertex);	// all edges from a vertex
	public ArrayList 	getEdges();			// return all edges
	
	public boolean 		isEmpty();
	public String 		toString();	
}