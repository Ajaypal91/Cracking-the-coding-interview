package treesAndGraphs.graphs;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class _2IsNodesReachable {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		SimpleAdjListGraph sag = CreateGraph.createGraph(sc);
		
		System.out.println("Enter the two nodes");
		
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		
		//get the starting and ending node
		Vertex v1 = null,v2 = null;
		for (Vertex v : sag.adjList.keySet()){
			if (v.data == n1)
				v1 = v;
			if (v.data == n2)
				v2 = v;
		}
		
		System.out.println(isNodesReacable(v1,v2,sag));
		
		sc.close();
		
	}
	
	//use bfs to check the connection
	private static boolean isNodesReacable(Vertex v1, Vertex v2, SimpleAdjListGraph sag){
		
		//perform BFS from root node v1
		Queue<Vertex> que = new LinkedList<>();
		que.offer(v1);
		v1.visited = true;
		
		while(!que.isEmpty()){
			Vertex v = que.poll();
			if (v == v2)
				return true;
			v.visited = true;
			for (Vertex x : sag.adjList.get(v)){
				if (!x.visited){
					que.offer(x);
				}
			}
		}
		
		
		return false;
	}
	
}
