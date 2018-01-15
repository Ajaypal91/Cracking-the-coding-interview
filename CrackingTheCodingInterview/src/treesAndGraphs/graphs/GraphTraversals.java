package treesAndGraphs.graphs;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class GraphTraversals {

	public static void BFSTraversal(Map<Vertex, LinkedList<Vertex>> adjList){
		
		Queue<Vertex> que = new LinkedList<>();
		Vertex v = adjList.keySet().iterator().next();
		System.out.println("BFS starting from vertex: "+v.data);
		que.offer(v);
		while(!que.isEmpty()){
			
			Vertex x = que.poll();
			if (!x.visited){
				System.out.println(x.data);
				x.visited = true;
			}
			for (Vertex i : adjList.get(x)){
				que.offer(i);
			}
			
		}
				
	}
	
	public static void DFSTraversal(Map<Vertex, LinkedList<Vertex>> adjList){
		
		Vertex v = adjList.keySet().iterator().next();
		System.out.println("DFS starting from vertex: "+v.data);
		DFS(v,adjList);
		
	}
	
	public static void DFS(Vertex root, Map<Vertex, LinkedList<Vertex>> adjList){
		
		if (root  == null)
			return;
		
		System.out.println(root.data);
		root.visited = true;
		
		for (Vertex v : adjList.get(root)){
			if (!v.visited)
				DFS(v, adjList);
		}
	}
	
}
