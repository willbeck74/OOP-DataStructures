import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Set;

public class Dijkstra1 {

	public static String findShortestPath(Graph1 graph, String startVertexName, String endVertexName) {
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
		PriorityQueue<Path> paths = new PriorityQueue<Path>();
		Set<String> visited = new HashSet<String>();
		Vertex startVertex = graph.getVertex(startVertexName);
		Vertex endVertex = graph.getVertex(endVertexName);

		if(startVertex == null || endVertex == null) return "path not found";

		paths.add(new Path(startVertex, 0, startVertexName));
		while(!(paths.isEmpty())) {
			Path currentState = paths.remove();
			System.out.println(currentState);
			if(currentState.vertex.equals(endVertex)) {
				int lastEnter = currentState.pathToThisVertex.lastIndexOf('\n');
				return "Shortest Path\n\t" + currentState.pathToThisVertex.substring(0, lastEnter) +
						"\nTotal Cost: " + currentState.totalCost;
			}
			visited.add(currentState.vertex.name);
			Map<String, Integer> currAdj = new HashMap<String, Integer>();
			Iterator<Edge> it = graph.getEdges().iterator();
			Edge tmp;
	        while (it.hasNext()) { 
	            tmp = it.next();
	            if (tmp.fromVertex.equals(currentState.vertex)) {
	            	 currAdj.put(tmp.toVertex.name, tmp.cost);
	            	 if(currentState != null)
	            		 edges.add(new Edge(tmp.fromVertex, tmp.toVertex, tmp.cost));
	            } 
	        } 
			for(Entry<String, Integer> entry : currAdj.entrySet()) {
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
		return "path not found1";
	}

}
