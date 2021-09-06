import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;

public class Dijkstra {

	public static String findShortestPath(Graph graph, String startVertexName, String endVertexName) {
		PriorityQueue<Edge> paths = new PriorityQueue<Edge>();
		Queue<Vertex> visited = new PriorityQueue<Vertex>();
		Vertex startVertex = graph.getVertex(startVertexName);
		Vertex endVertex = graph.getVertex(endVertexName);
		
		if(startVertex == null || endVertex == null) return "path not found";
		
		paths.add( new Edge(startVertex, endVertex, 0) );
		while(!paths.isEmpty()) {
			Edge currentState = paths.remove();
			if(currentState.toVertex.equals(endVertex)) {
				int lastEnter = currentState.cost;
				return "Shortest Path\n\t" + currentState.pathToThisVertex.substring(0, lastEnter) + 
						"\nTotal Cost: " + currentState.totalCost;
			}
			visited.add(currentState.fromVertex);
			Map<String, Integer> currAdj = new HashMap<String, Integer>();
			for(Map.Entry<String, Integer> entry : currAdj.entrySet()) {
				if(!visited.contains(entry.getKey())) {
					paths.add(new Path(graph.getVertex(entry.getKey()), 
							currentState.totalCost + entry.getValue(), 
							currentState.pathToThisVertex + " -> " + 
							entry.getKey() + " (" + entry.getValue() + ")\n\t" +
									entry.getKey()
							));
				}
			}
		}
		return "path not found";
		
	}
}
