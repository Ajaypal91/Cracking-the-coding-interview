package treesAndGraphs.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SimpleAdjListGraph {
	

	Map<Vertex, LinkedList<Vertex>> adjList = new HashMap<>();	
	
	public void insertIntoAdjList(Vertex node, List<Vertex> adjL){
		
		adjList.put(node, new LinkedList<>(adjL));
		
	}
	
	public void resetGraph(){
		for (Vertex v : adjList.keySet())
			v.visited = false;
	}
	
}
